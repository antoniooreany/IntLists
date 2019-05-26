package Kratzer.IntList;

import Kratzer.ListException;

public class IntList {

	private class ListElement {
		private int info;
		private ListElement next;
		
		public ListElement(int info, ListElement next) {
			this.info = info;
			this.next = next;
		}

		public ListElement(int info) {
			this.info = info;
			this.next = null;
		}
	}
	
	private ListElement first;
	private ListElement last;
	
	public IntList() {
		first = null;
		last = null;
	}
	
	public boolean isEmpty() {
		return first == null; 
	}
	
	public void insertFirst(int newValue) {
		first = new ListElement(newValue, first);
		if (last == null)
			last = first;
	}
	
	public void insertLast(int newValue) {
		if (isEmpty())
			insertFirst(newValue);
		else
			last = (last.next = new ListElement(newValue));
	}
	
	public void deleteFirst() {
		if (isEmpty()) throw new ListException();
		first = first.next;
		if (first == null) last = null;
	}
	
	public void deleteLast() {
		if (isEmpty() || first == last)
			deleteFirst();
		else {
			ListElement frog;
			for (frog = first; frog.next != last; frog = frog.next);
			last = frog;
			frog.next = null;
		}
	}
	
	public int firstElement() {
		if (isEmpty()) throw new ListException();
		return first.info;
	}
	
	public int lastElement() {
		if (isEmpty()) throw new ListException();
		return last.info;
	}
	
	public int size() {
		int res = 0;
		
		for (ListElement frog = first; frog != null; frog = frog.next)
			++res;
		
		return res;
	}
	
	public boolean equals(Object obj) {
		return false;
	}
	
	public String toString() {
		if (isEmpty()) return "";
		
		String res = "";
		
		for (ListElement frog = first; frog != null; frog = frog.next)
			res += frog.info + " / ";
				
		return res.substring(0, res.length() - 3);		
	}
	
}
