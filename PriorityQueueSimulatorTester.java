/*
 * COMP 352 - Assignment 3
 * @author: Mohanad Arafe & Hambrsoom Baboyan
 * Student ID: 40042922 & 40054395
 * Date: November 12, 2018 
 * --------------- Driver Class ----------------
 * In this part of the assignment, we must test
 * out our priority queue's and start giving the
 * CPU a range of jobs. The output file gives full
 * analysis of each PQ.
 */

import java.io.*;

public class PriorityQueueSimulatorTester {
	
//Creating the initial array of jobs:
	public static Job[] creatInputJobArray(int k, Job[]arr) {
		for (int i =0; i<k;i++) {
			String jobName       = "JOB_"+i+1;
			int r                = (int) (Math.random() * (70 - 1)) + 1;
			int jobLength        = r;
			int currentJobLength = r;
			int pr               = (int) (Math.random() * (40 - 1)) + 1;
			int jobPriority      = pr;
			int finalPriority    = pr;
			long entryTime       = 0, endTime=0, waitTime =0;
			long age             = 0;
			Job newJob           = new Job(jobName,jobLength,currentJobLength,jobPriority,finalPriority,entryTime,endTime,waitTime,age);
			arr[i]               = newJob;
		}
		return arr;
	}
	

	public static void CpuSimulator_Heap(Array_Heap arrayHeap, int counterAge, int count,int size,PrintWriter pw) {
		long[] waitArr           = new long [size];
		int positionWaitArr      =0;
		int numOfPriorityChanges =0;
		long endTime=0;
		 long startTime = System.currentTimeMillis();
		while (!arrayHeap.isEmpty()) {
			boolean doIt = false;
			int k =0;
			while(k!=30) {
				count      = count +1;
				Entry <Job,Integer,Integer> e1 =arrayHeap.removeMin();
				System.out.println("Now executing "+ ((Job) e1.value).jobName +". Job length: "+ ((Job) e1.value).jobLength +
						" cycles; Current remaing length: "+ ((Job) e1.value).jobCurrentLength +" cycles; Initial priority: "+ ((Job) e1.value).jobPriority +";"+
						" Current priority: "+ ((Job) e1.value).jobFinalPriority);
				((Job) e1.value).jobCurrentLength =((Job) e1.value).jobCurrentLength -1;
				if(((Job) e1.value).jobCurrentLength ==0){
					k++;
					Long waitTime = count - ((Job) e1.value).jobLength - ((Job) e1.value).entryTime ;
					waitArr[positionWaitArr]= waitTime;
					positionWaitArr +=1;
					if(arrayHeap.isEmpty()) {
						break;
					}
				}
				else {
					counterAge = counterAge+1;
					e1.key2 = counterAge;
					((Job) e1.value).age =((Job) e1.value).age +1;
					arrayHeap.Insert(e1);
					k++;
				}
			}
			for(int i =0; i <arrayHeap.getRightMost();i++) {
				if(((Job)arrayHeap.arr[i].value).entryTime ==((Job)arrayHeap.arr[i].value).jobCurrentLength) {
					doIt =true;
					break;
				}
			}
			
			if(!arrayHeap.isEmpty() && doIt ==true) {
				numOfPriorityChanges += StarvationHeap(arrayHeap,size,numOfPriorityChanges);
				count = count+1;
			}
			endTime = System.currentTimeMillis();
		}	
			long AverageWaitingTime = CalculateAverage(waitArr);
				
//Printing out:
		pw.println("Array Heap:");
		pw.println("Current system time (cycles): " + count);
		pw.println("Total number of jobs executed: " + size);
		pw.println("Average process waiting time: "+ AverageWaitingTime);
		pw.println("Total number of priority changes: "+ numOfPriorityChanges);
		pw.println("Actual system time needed to execute all jobs: " +(endTime-startTime)+"ms.");
		pw.println();
	}
	
//Starvation method for the Array_Heap:
	public static int StarvationHeap(Array_Heap arrayHeap, int size, int numOfPriorityChanges) {
		Entry poorJob = new Entry<Job,Integer,Integer>();
		      poorJob = arrayHeap.arr[0];
		      int counter=1;
		for (int i =1; i<size; i++) {
			if(arrayHeap.arr[i]!=null) {
				if((arrayHeap.arr[i].key1.compareTo(poorJob.key1))==1) {
					poorJob = arrayHeap.arr[i];
					counter=i;
				}
			}
		}
		if(poorJob !=null && counter <= arrayHeap.getRightMost() ) {
			((Job) poorJob.value).jobFinalPriority = 1;
			poorJob.key1 =1;
			numOfPriorityChanges =numOfPriorityChanges +1;
			arrayHeap.upHeap(counter);
		}
		return 1;
	}
//Calculating average Wait Time
	public static long CalculateAverage(long[] waitTime) {
		long AverageWaitingTime=0;
		for (int i =0; i<waitTime.length;i++) {
			AverageWaitingTime += (long)waitTime[i];
		}
		AverageWaitingTime = AverageWaitingTime/(long)(waitTime.length);
		return AverageWaitingTime;
	}
	
	
//UnsortedList:
	public static void CpuSimulator_unsoretedList(UnsortedList unsortedList, int counterAge, int count,int size,PrintWriter pw) {
		long[] waitArr           = new long [size];
		int positionWaitArr      =0;
		int numOfPriorityChanges =0;
		long endTime             =0;
		long startTime = System.currentTimeMillis();
		while (!unsortedList.isEmpty()) {
			boolean doIt = false;
			int k =0;
			while(k!=30) {
				count      = count +1;
				Entry <Job,Integer,Integer> e1 =unsortedList.removeMin();
				System.out.println("Now executing "+ ((Job) e1.value).jobName +". Job length: "+ ((Job) e1.value).jobLength +
						" cycles; Current remaing length: "+ ((Job) e1.value).jobCurrentLength +" cycles; Initial priority: "+ ((Job) e1.value).jobPriority +";"+
						" Current priority: "+ ((Job) e1.value).jobFinalPriority);
				((Job) e1.value).jobCurrentLength =((Job) e1.value).jobCurrentLength -1;
				if(((Job) e1.value).jobCurrentLength ==0){
					k++;
					Long waitTime = count - ((Job) e1.value).jobLength - ((Job) e1.value).entryTime ;
					waitArr[positionWaitArr]= waitTime;
					positionWaitArr +=1;
					if(unsortedList.isEmpty()) {
						break;
					}
				}
				else {
					counterAge = counterAge+1;
					e1.key2 = counterAge;
					((Job) e1.value).age =((Job) e1.value).age +1;
					unsortedList.insert(e1);
					k++;
				}
			}
			for(int i =0; i <unsortedList.size();i++) {
				if(((Job)unsortedList.unsortedList[i].value).entryTime ==((Job)unsortedList.unsortedList[i].value).jobCurrentLength) {
					doIt =true;
					break;
				}
			}
			if(!unsortedList.isEmpty() && doIt ==true) {
				numOfPriorityChanges += StarvationUsortedList(unsortedList,size,numOfPriorityChanges);
				count = count+1;
			}
			endTime = System.currentTimeMillis();
		}	
			long AverageWaitingTime = CalculateAverage(waitArr);
				
//Printing out:
		pw.println("Unsorted List:");
		pw.println("Current system time (cycles): " + count);
		pw.println("Total number of jobs executed: " + size);
		pw.println("Average process waiting time: "+ AverageWaitingTime);
		pw.println("Total number of priority changes: "+ numOfPriorityChanges);
		pw.println("Actual system time needed to execute all jobs: "+(endTime-startTime)+"ms.");
		pw.println();
	}
	
	public static int StarvationUsortedList(UnsortedList unsortedList, int size, int numOfPriorityChanges) {
		Entry poorJob = new Entry<Job,Integer,Integer>();
		      poorJob = unsortedList.unsortedList[0];
		      int counter=1;
		for (int i =1; i<size; i++) {
			if(unsortedList.unsortedList[i]!=null) {
				if((unsortedList.unsortedList[i].key1.compareTo(poorJob.key1))==1) {
					poorJob = unsortedList.unsortedList[i];
					counter=i;
				}
			}
		}
		if(poorJob !=null && counter <= unsortedList.size()) {
			((Job) poorJob.value).jobFinalPriority = 1;
			poorJob.key1 =1;
			numOfPriorityChanges =numOfPriorityChanges +1;
		}
		return 1;
	}
	
	public static void CpuSimulator_Sorted(SortedList list, int counterAge, int count, int size, PrintWriter pw){

		long[] waitArr           = new long [size];
		int positionWaitArr      =0;
		int numOfPriorityChanges =0;
		long startTime = System.currentTimeMillis();
		long endTime = 0;
	
		while(!list.isEmpty()){
			int k = 0;
			while(k != 30){
				count++;
				Entry<Job, Integer, Integer> e1 = list.removeMin();
				System.out.println("Now executing "+ ((Job) e1.value).jobName +". Job length: "+ ((Job) e1.value).jobLength +
						" cycles; Current remaing length: "+ ((Job) e1.value).jobCurrentLength +" cycles; Initial priority: "+ ((Job) e1.value).jobPriority +";"+
						" Current priority: "+ ((Job) e1.value).jobFinalPriority);
				((Job) e1.value).jobCurrentLength = ((Job) e1.value).jobCurrentLength -1;
				if(((Job)e1.value).jobCurrentLength == 0){
					k++;
					Long waitTime = count - ((Job)e1.value).jobLength - ((Job)e1.value).entryTime;
					waitArr[positionWaitArr]= waitTime;
					positionWaitArr++;
					if(list.isEmpty())
						break;
				}else{
					counterAge++;
					e1.key2 = counterAge;
					((Job)e1.value).age = ((Job)e1.value).age + 1;
					list.insert(e1);
					k++;
				}
			}
			if(!list.isEmpty()){
				numOfPriorityChanges += Starvation_Sorted(list, size, numOfPriorityChanges);
				count++;
			}
			endTime = System.currentTimeMillis();
		}
		long AverageWaitingTime = CalculateAverage(waitArr);
		pw.println("Sorted-List PQ:");
		pw.println("Current system time (cycles): " + count);
		pw.println("Total number of jobs executed: " + size);
		pw.println("Average process waiting time: "+ AverageWaitingTime);
		pw.println("Total number of priority changes: "+ numOfPriorityChanges);
		pw.println("Actual system time needed to execute all jobs: " + (endTime-startTime) + "ms.");	
		pw.println();	
	}
	
	
	public static int Starvation_Sorted(SortedList list, int size, int numOfPriorityChanges){
		Entry poorJob = new Entry<Job, Integer, Integer>();	
		poorJob = list.sortedList[0];
		int counter = 1;
		for(int i = 0; i < size; i++){
			if(list.sortedList[i] != null){
				if(list.sortedList[i].key1.compareTo(poorJob.key1) == 1){
					poorJob = list.sortedList[i];
					counter = i;	
				}
			}
		}
		if(poorJob !=null && counter <= list.size()) {
			((Job) poorJob.value).jobFinalPriority = 1;
			poorJob.key1 =1;
			numOfPriorityChanges =numOfPriorityChanges +1;
			list.sort();
		}
		return 1;
	}

	public static void main(String[] args) {
		PrintWriter pw= null;
        try{	
        pw = new PrintWriter(new FileOutputStream("SimulatorPerformanceResults.txt"));
        }
        catch (FileNotFoundException e){
        System.out.println(e.getStackTrace());
        } 
		
//number of Jobs:
		int[] maxNumberOfJobs = {10,100, 1000, 10000, 100000, 1000000};
		
//It will loop on the maxNumberOfJobs array:

		for (int i =0; i<4;i++) {
			int counterAgeHeap=0;
			int countHeap=0;
			Job[] jobsInputArray  = new Job[maxNumberOfJobs[i]];
			jobsInputArray = creatInputJobArray(maxNumberOfJobs[i],jobsInputArray);
			Array_Heap arrayHeap = new Array_Heap(maxNumberOfJobs[i]);
			for(int j=0; j<jobsInputArray.length;j++) {
				counterAgeHeap++;
				countHeap++;
				Entry e1 = new Entry<Job,Integer,Integer>(jobsInputArray[j],jobsInputArray[j].jobFinalPriority,counterAgeHeap);
				((Job) e1.value).age=counterAgeHeap;
				((Job) e1.value).entryTime=counterAgeHeap;
				arrayHeap.Insert(e1);	
			}
			arrayHeap.toString();
			CpuSimulator_Heap(arrayHeap,counterAgeHeap,countHeap,maxNumberOfJobs[i],pw);
			jobsInputArray =null;
		}
		

		for(int i =0; i<4;i++) {
			int counterAgeUnsortedList=0;
			int countUnsortedList=0;
			Job[] jobsInputArray  = new Job[maxNumberOfJobs[i]];
			jobsInputArray = creatInputJobArray(maxNumberOfJobs[i],jobsInputArray);
			UnsortedList unsortedList = new UnsortedList(maxNumberOfJobs[i]);
			for(int j=0; j<jobsInputArray.length;j++) {
				counterAgeUnsortedList++;
				countUnsortedList++;
				Entry e1 = new Entry<Job,Integer,Integer>(jobsInputArray[j],jobsInputArray[j].jobFinalPriority,counterAgeUnsortedList);
				((Job) e1.value).age=counterAgeUnsortedList;
				((Job) e1.value).entryTime=counterAgeUnsortedList;
				unsortedList.insert(e1);	
			}
			System.out.println(unsortedList.toString());
			CpuSimulator_unsoretedList(unsortedList,counterAgeUnsortedList,countUnsortedList,maxNumberOfJobs[i],pw);
		}
		
		

	
		//Sorted List PQ
		for(int i = 0; i < 3; i++){
			int counterAge = 0; int count = 0;
			Job[] jobsInputArray = new Job[maxNumberOfJobs[i]];
			jobsInputArray = creatInputJobArray(maxNumberOfJobs[i],jobsInputArray);			
			SortedList list = new SortedList(maxNumberOfJobs[i]);
			for(int j = 0; j < jobsInputArray.length; j++){
				counterAge++;
				count++;
				Entry e1 = new Entry<Job, Integer, Integer>(jobsInputArray[j], jobsInputArray[j].jobFinalPriority, counterAge);
				((Job) e1.value).age = counterAge;
				((Job) e1.value).entryTime = counterAge;
				list.insert(e1);
			}
			CpuSimulator_Sorted(list, counterAge, count, maxNumberOfJobs[i], pw);
			jobsInputArray = null;
		}
		pw.close();
	}

}
