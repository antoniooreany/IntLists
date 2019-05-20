package intSortedList;

import auxiliary.ListException;

public class IntSortedList {

	private class IntSortedListElement {
		private int info;
		private IntSortedListElement next;
		
		public IntSortedListElement(int info, IntSortedListElement next) {
			this.info = info;
			this.next = next;
		}

		public IntSortedListElement(int info) {
			this.info = info;
			this.next = null;
		}
	}
	
	private IntSortedListElement first;
	private IntSortedListElement last;
	
	public IntSortedList() {
		first = null;
		last = null;
	}
	
	public boolean isEmpty() {
		return first == null; 
	}
	
	public void insert(int newValue) {
		IntSortedListElement prevElem = null;
		IntSortedListElement elem = first;
		while (newValue < elem.info && elem != null) {
			prevElem = elem;
			elem = elem.next;
		}
		prevElem = new IntSortedListElement(newValue, elem);
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
		
		for (IntSortedListElement frog = first; frog != null; frog = frog.next)
			++res;
		
		return res;
	}
	
	public boolean equals(Object obj) {
		return false;
	}
	
	public String toString() {
		if (isEmpty()) return "";
		
		String res = "";
		
		for (IntSortedListElement frog = first; frog != null; frog = frog.next)
			res += frog.info + " / ";
				
		return res.substring(0, res.length() - 3);		
	}
	
}
