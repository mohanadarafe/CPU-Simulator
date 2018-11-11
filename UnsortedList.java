/*
 * COMP 352 - Assignment 3
 * @author: Mohanad Arafe & Hambrsoom Baboyan
 * Student ID: 40042922 & 40054395
 * Date: November 12, 2018 
 * --------------- Unsorted List Class ----------------
 * In this part of the assignment, we must implement
 * an unsorted list in the form of an array. The method
 * contains the insert() and removeMin() methods in order
 * to test out the Priority Queue.
 */

public class UnsortedList{
	private int currentSize;
	private int maxSize;
	public Entry[] unsortedList;

	//Constructors
	public UnsortedList(){
	
		currentSize = 0;
		maxSize = 0;
		unsortedList =  new Entry[this.maxSize];
	}

	public UnsortedList(int maxSize){
		currentSize = 0;
		this.maxSize = maxSize;
		this.unsortedList =  new Entry[this.maxSize];		
	}

	//Get & Set
    public int getCurrentSize() {return currentSize;}
    public void setCurrentSize(int currentSize) {this.currentSize = currentSize; }
	 public int getMaxSize() { return maxSize;}
	 public void setMaxSize(int maxSize) { this.maxSize = maxSize;}

	//Queue operations
	public int size(){
		return currentSize;
	}

	public boolean isEmpty(){
		return (currentSize==0);
	}
	
	public void insert(Entry object){
		if(size() == maxSize) {
			System.out.println("Cannot insert  since the array is full!");	
		}
		else{	
			unsortedList[currentSize] = object;
			currentSize               = currentSize +1;
		}
	}

	
	public Entry removeMin() {
		if(isEmpty()) {
			System.out.println("Cannot remove since the array is empty!");	
			return null;
		}
		else {
			int index = searchMin();
			Entry temp = unsortedList[index];
			unsortedList[index] = null;
			for (int i=index; i<size();i++) {
				if(i+1 < size()) {
					unsortedList[i]= unsortedList[i+1];	
				}
			}
			currentSize = currentSize-1;
			return temp;
		}
		
	}

	public String toString() {
		String line ="";
		for (int i =0;i<size();i++) {
			if(unsortedList[i]!=null) {
				line += unsortedList[i].toString()+ " ";
			}
		}
		return line;
	}
	public int searchMin () {
		int minimumElementPosition =0;
		int j=0;
		for (int i=0; i<size(); i++) {
					if((unsortedList[minimumElementPosition].compareTo(unsortedList[i]))==1) {
						minimumElementPosition =i;
					}		
					
		}
		return minimumElementPosition;
	}

	public static void main(String[] args){
		Entry[] arr = new Entry[7];
		UnsortedList queue =  new UnsortedList(7);
		Entry e1 = new Entry <String,Integer,Integer>("key7key4",7,4);
		Entry e2 = new Entry <String,Integer,Integer>("key5",5,9);
		Entry e3 = new Entry <String,Integer,Integer>("key9",9,122);
		Entry e4 = new Entry <String,Integer,Integer>("key12",12,122);
		Entry e5 = new Entry <String,Integer,Integer>("key1",1,122);
		Entry e6 = new Entry <String,Integer,Integer>("key7key122",7,122);
		Entry e7 = new Entry <String,Integer,Integer>("key2",1,1);
		
		queue.insert(e1);
		queue.insert(e2);
		queue.insert(e3);	
		queue.insert(e4);	
		queue.insert(e5);	
		queue.insert(e6);
		queue.insert(e7);
		System.out.println(queue.removeMin().toString());
		queue.removeMin();
		queue.removeMin();
		queue.removeMin();
		queue.insert(e5);
		System.out.println(queue.toString());
	}

}
