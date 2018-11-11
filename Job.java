/*
 * COMP 352 - Assignment 3
 * @author: Mohanad Arafe & Hambrsoom Baboyan
 * Student ID: 40042922 & 40054395
 * Date: November 12, 2018 
 * --------------- Job Class ----------------
 * In this part of the assignment, we must implement
 * a job class which beholds all the characteristics
 * of a Job in the CPU. 
 */

public class Job {
	
//Attributes:
	public String  jobName;
	public int     jobLength;
	public int     jobCurrentLength;
	public int     jobPriority;
	public int     jobFinalPriority;
	public long    entryTime;
	public long    endTime;
	public long    waitTime;
	public long    age;
	
//Constructors:
	public Job() {
		jobName         =null;
		jobLength       =0;
		jobCurrentLength=0;
		jobPriority     =0;
        jobFinalPriority=0;
		entryTime       =0;
		endTime         =0;
		waitTime        =0;
		age             =0;
	}
	public Job(String jobName, int jobLength, int jobCurrentLength,int jobPriority, int jobFinalPriority, long entryTime, long endTime, long waitTime,long age) {
		this.jobName         =jobName;
		this.jobLength       =jobLength;
		this.jobCurrentLength=jobCurrentLength;
		this.jobPriority     =jobPriority;
        this.jobFinalPriority=jobFinalPriority;
		this.entryTime       =entryTime;
		this.endTime         =endTime;
		this.waitTime        =waitTime;
		this.age             =age;
	}

	//Setters and Getters:
	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public int getJobLength() {
		return jobLength;
	}

	public void setJobLength(int jobLength) {
		this.jobLength = jobLength;
	}

	public int getJobCurrentLength() {
		return jobCurrentLength;
	}

	public void setJobCurrentLength(int jobCurrentLength) {
		this.jobCurrentLength = jobCurrentLength;
	}

	public int getJobPriority() {
		return jobPriority;
	}

	public void setJobPriority(int jobPriority) {
		this.jobPriority = jobPriority;
	}

	public int getJobFinalPriority() {
		return jobFinalPriority;
	}

	public void setJobFinalPriority(int jobFinalPriority) {
		this.jobFinalPriority = jobFinalPriority;
	}

	public long getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(long entryTime) {
		entryTime = entryTime;
	}

	public long getEndTime() {
		return endTime;
	}

	public void setEndTime(long endTime) {
		endTime = endTime;
	}
	
	
	public long getWaitTime() {
		return waitTime;
	}
	public void setWaitTime(long waitTime) {
		this.waitTime = waitTime;
	}
	public long getAge() {
		return age;
	}
	public void setAge(long age) {
		this.age = age;
	}
	public String toString() {
		return "("+jobName+ "-(initial: "+ jobPriority + " -(final:"+ jobFinalPriority +")";
	}
	
	
//main method:
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
