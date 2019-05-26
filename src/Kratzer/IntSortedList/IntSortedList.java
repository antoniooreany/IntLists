package Kratzer.IntSortedList;

import Kratzer.ListException;

public class IntSortedList {

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
	
	public IntSortedList() {
		first = null;
		last = null;
	}
	
	public boolean isEmpty() {
		return first == null; 
	}
	
	public void insert(int newValue) {
		
		// find insertion point
		ListElement frog;
		ListElement backfrog;
		
		for (frog = first, backfrog = null; 
			 frog != null && frog.info < newValue; 
			 backfrog = frog, frog = frog.next);
		
		// insert
	}
		
	public void delete(int value) {
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
