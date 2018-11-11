/*
 * COMP 352 - Assignment 3
 * @author: Mohanad Arafe & Hambrsoom Baboyan
 * Student ID: 40042922 & 40054395
 * Date: November 12, 2018 
 * --------------- Entry Class ----------------
 * In this part of the assignment, we must implement
 * a generic Entry class which holds objects & keys.
 * Also, the method contains a compareTo implementation. 
 */

public class Entry <s,k1 extends Comparable <k1>,k2 extends Comparable <k2>> implements Comparable<Entry <s,k1,k2>> {
//Attributes
		public s  value;
		public k1 key1;
		public k2 key2;
		public Entry() {
			value = null;
			key1  = null;
			key2  = null;
		}
		public Entry(s value, k1 key1, k2 key2) {
			this.value = value;
			this.key1  = key1;
			this.key2  = key2;
		}
		public String toString() {
			return value.toString();
		}

//Getters and Setters
		public s getValue() {
			return value;
		}
		public void setValue(s value) {
			this.value = value;
		}
		public k1 getKey1() {
			return key1;
		}
		public void setKey1(k1 key1) {
			this.key1 = key1;
		}
		public k2 getKey2() {
			return key2;
		}
		public void setKey2(k2 key2) {
			this.key2 = key2;
		}
		public int compareTo(Entry <s,k1,k2> o) {
			
//will return 1 if this > o ; 0 if they are equal and -1 if this < o:
			if(this.key1.compareTo(o.key1) == 0) {
				return (this.key2.compareTo(o.key2));
			}
			else {
				return this.key1.compareTo(o.key1);
			}
		}
		
//Swapping method:
		public void Swap(Entry e1, Entry e2) {
			Entry  temp = new Entry <s,k1,k2>();
			temp.setKey1(e1.key1);
			temp.setKey2(e1.key2);
			temp.setValue(e1.value);
			e1.setKey1(e2.key1);
			e1.setKey2(e2.key2);
			e1.setValue(e2.value);
			e2.setKey1(temp.key1);
			e2.setKey2(temp.key2);
			e2.setValue(temp.value);
		}
		
		public static void main(String[]args) {
			Entry e1 = new Entry <String,Integer,Integer>();
			e1.key1=2;
			e1.key2=2;
			e1.value="poato";
			Entry e2 = new Entry <String,Integer,Integer>();
			e2.key1=2;
			e2.key2=3;
			e2.value="koko";
			System.out.println(e1.compareTo(e2));
			e1.Swap(e1,e2);
			System.out.println(e1.value);
			System.out.println(e2.value);
		}
		
	}
