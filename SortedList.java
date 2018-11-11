/*
 * COMP 352 - Assignment 3
 * @author: Mohanad Arafe & Hambrsoom Baboyan
 * Student ID: 40042922 & 40054395
 * Date: November 12, 2018 
 * --------------- Sorted List Class ----------------
 * In this part of the assignment, we must implement
 * a sorted list in the form of an array. The method
 * contains the insert() and removeMin() methods in order
 * to test out the Priority Queue.
 */

public class SortedList{

	private int currentSize;
	private int maxSize;
	public Entry[] sortedList;

	//Constructors	
	public SortedList(){
		currentSize = 0;	
		maxSize = 0;
		sortedList = (Entry[]) new Entry[maxSize];
	}

	public SortedList(int maxSize){
		currentSize = 0;
		this.maxSize = maxSize;
		sortedList = new Entry[this.maxSize];
	}
	
	public SortedList(Entry[] sortedList, int maxSize){
		currentSize = 0;
		this.maxSize = maxSize;
		this.sortedList = new Entry[this.maxSize];
	}
	
	//PQ Operations
	public int size(){
		int counter = 0;
		for(int i = 0; i < maxSize; i++){
			if(sortedList[i] != null)
				counter++;
		}
		return counter;
	}

	public boolean isEmpty(){
		return (size() == 0);
	}

	//Selection sort whenever we insert()
	public void sort(){
		Entry temp = sortedList[0];
		for(int i = 0; i < currentSize; i++){
			for(int j = i+1; j < currentSize; j++){
				if(sortedList[i] != null && sortedList[j] !=null){
					if(sortedList[i].compareTo(sortedList[j]) > 0){
						temp = sortedList[i];
						sortedList[i] = sortedList[j];
						sortedList[j] = temp;
					}
				}
			} 
		}
	}

	//Shift array to the left whenever we removeMin()
	public void shift(){
		for(int i = 0; i < currentSize; i++){
			sortedList[i] = sortedList[i+1];
		}
		sortedList[currentSize] = null;
	}

	public void insert(Entry object){
		if(size() == maxSize)
			System.out.println("Cannot insert since the Queue is full.");
		else{
			sortedList[currentSize] = object;
			currentSize++;
			sort();
		}
	}

	public Entry removeMin(){
		if(isEmpty()){
			System.out.println("Cannot remove since the Queue is empty.");
			return null;
		}
		else{
			Entry temp = sortedList[0];
			sortedList[0] = null;
			currentSize--;
			shift();
			return temp;
		}
	}

	public String toString(){
		String line = "[";
		for(int i = 0; i < maxSize; i++){
			if(sortedList[i] != null)
				line = line + sortedList[i].getValue() + " ";
			else
				line = line + "null ";
		}
		return line + "]";
	}

	public static void main(String[] args){
		Entry[] arr = new Entry[7];
		SortedList list = new SortedList(arr, 7);
		Entry e1 = new Entry<String, Integer, Integer>("first", 1, 21);
		Entry e2 = new Entry<String, Integer, Integer>("sixth", 6, 98);
		Entry e3 = new Entry<String, Integer, Integer>("fourth", 4, 32);
		Entry e4 = new Entry<String, Integer, Integer>("second fourth", 4, 33);
		Entry e5 = new Entry<String, Integer, Integer>("second", 2, 1);
		Entry e6 = new Entry<String, Integer, Integer>("fifth", 5, 1);
		Entry e7 = new Entry<String, Integer, Integer>("third", 3, 1);
		list.insert(e1);
		list.insert(e2);
		list.insert(e3);
		list.insert(e5);
		list.insert(e6);
		list.insert(e7);
		list.removeMin();
		list.removeMin();
		list.removeMin();
			list.removeMin();
			list.removeMin();
			list.removeMin();
			list.removeMin();
	
		System.out.println(list.toString());
	}
	

}
