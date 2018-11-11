/*
 * COMP 352 - Assignment 3
 * @author: Mohanad Arafe & Hambrsoom Baboyan
 * Student ID: 40042922 & 40054395
 * Date: November 12, 2018 
 * --------------- Array Heap Class ----------------
 * In this part of the assignment, we must implement
 * an array list based heap which will operate in O(nlogn) 
 */

public class Array_Heap {
	
//Attributes	
	public Entry[] arr ;
	private int size;
	private int rightMost = -1;
	
//Constructors
	public Array_Heap() {
		arr         = new Entry[size];
		size        = 0;
 		rightMost   = -1;
	}
	public Array_Heap(int size) {
		this.size        = size;
 		rightMost   	 = -1;
 		arr              = new Entry[size];
	}
	public Array_Heap(Entry[]arr,int size) {
		this.rightMost   = -1;
		this.size        = size;
		this.arr         = new Entry[size];
	}
//An inner class for what we will be storing in the array
	
//Setters and Getters
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getRightMost() {
		return rightMost;
	}
	public void setRightMost(int rightMost) {
		this.rightMost = rightMost;
	}
	
//It will insert at the rightMost then heapify it
	public void Insert(Entry newNode) {
//do you want to make it bigger ?
		if(rightMost >= arr.length-1) {
			System.out.println("A full array");
		}
		else 
			rightMost = rightMost+1;
			arr[rightMost] = newNode;
		 this.upHeap(rightMost);
//dont forget to sort it Up-Heap
	}
	public void upHeap(int i) {
			while(i>0) {
					if(arr[(i-1)/2].compareTo(arr[i])==1) {
						arr[i].Swap(arr[(i-1)/2],arr[i]);
					}
					i = (i-1)/2;
			}
	}
//Sorting the heap (putting the min on the top)
	
	public Entry removeMin() {
		if(this.isEmpty()) {
			System.out.println("The heap is empty");
			return null;
		}
		else {
			Entry temp = new Entry(arr[0].value,arr[0].key1,arr[0].key2);
			arr[0].Swap(arr[0],arr[rightMost]);
			arr[rightMost]=null;
			rightMost      = rightMost-1;
			this.bottomDown(0);
			return temp;
		}
	}
	
//Bottom-down the heap after executing removeMin():
	public void bottomDown(int i) {
		if(i >= (rightMost-1)/2) {
		}
		else {
			if(arr[2*i+1].compareTo(arr[2*i+2])==1 && arr[i].compareTo(arr[2*i+2])==1) {
				arr[i].Swap(arr[i],arr[2*i+2]);
				bottomDown(2*i+2);
			}
			else if(arr[2*i+1].compareTo(arr[2*i+2])==-1 &&arr[i].compareTo(arr[2*i+1])==1) {
				arr[i].Swap(arr[i], arr[2*i+1]);
				bottomDown(2*i+1);
			}
			else {
				System.out.println("Sorted");
			}
				
		}
	}

	public void sort(int i) {
		if(i >= (rightMost-1)/2) {
		}
		else {
			if(arr[2*i+1].compareTo(arr[2*i+2])==1 && arr[i].compareTo(arr[2*i+2])==1) {
				arr[i].Swap(arr[i],arr[2*i+2]);
				sort(0);
			}
			if(arr[2*i+1].compareTo(arr[2*i+2])==-1 &&arr[i].compareTo(arr[2*i+1])==1) {
				arr[i].Swap(arr[i], arr[2*i+1]);
				bottomDown(0);
			}
			else {
				sort(i+1);
			}
				
		}
	}
//will verify if the heap is empty
	public boolean isEmpty() {
		if(arr[0]==null) {
			return true;
		}
		else {
			return false;
		}
	}
	public String toString() {
		String line = "";
		for (int i =0;i<arr.length;i++) {
			if(arr[i]!=null) {
				line += arr[i].toString()+ " ";
			}
		}
		return line;
	}

	

	public static void main(String[] args) {
		Entry[]arr = new Entry[10];
		Array_Heap kok = new Array_Heap(arr,10);
		Entry e2 = new Entry <String,Integer,Integer>("a",10,4);
		kok.Insert(e2);
		Entry e3 = new Entry <String,Integer,Integer>("b",9,4);
		Entry e4 = new Entry <String,Integer,Integer>("c",8,9);
		Entry e5 = new Entry <String,Integer,Integer>("d",7,3);
		Entry e6 = new Entry <String,Integer,Integer>("e",6,2);
		Entry e7 = new Entry <String,Integer,Integer>("f",5,4);
		Entry e8 = new Entry <String,Integer,Integer>("g",7,122);
		Entry e9 = new Entry <String,Integer,Integer>("h",2,4);
		
		kok.Insert(e3);
		kok.Insert(e4);
		kok.Insert(e5);
		kok.Insert(e6);
		kok.Insert(e7);
		kok.Insert(e8);
		kok.Insert(e9);
		
		
		System.out.println("f: " + kok.isEmpty());
		System.out.println("toString: "+ kok.toString());	
		kok.removeMin();
		kok.removeMin();
		Entry e10 = new Entry <String,Integer,Integer>("i",1,3);
		kok.Insert(e10);
		System.out.println("toString: "+ kok.toString());	
		
		
	}

}
