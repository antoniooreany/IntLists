package Kratzer.intDoubleList;

import Kratzer.intSortedList.ListException;

public class IntDoubleList {

	private class ListElement {
		private int info;
		private ListElement next;
		private ListElement prior;
		
		public ListElement(int info, ListElement next, ListElement prior) {
			this.info = info;
			this.next = next;
			this.prior = prior;
		}

		public ListElement(int info) {
			this.info = info;
			this.next = null;
			this.prior = null;
		}
	}
	
	private ListElement first;
	private ListElement last;
	
	public IntDoubleList() {
		first = null;
		last = null;
	}
	
	public boolean isEmpty() {
		return first == null; 
	}
	
	public void insertFirst(int newValue) {
	}
	
	public void insertLast(int newValue) {
	}
	
	public void deleteFirst() {
	}
	
	public void deleteLast() {
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
		return toString(Direction.FORWARD);
	}
	
	public String toString(Direction d) {
		
		if (isEmpty()) return "";
	
		String res = "";
	
		switch (d) {
		
		case FORWARD:
			for (ListElement frog = first; frog != null; frog = frog.next)
				res += frog.info + " / ";
			break;
		case BACKWARD:
			for (ListElement frog = last; frog != null; frog = frog.prior)
				res += frog.info + " / ";
			break;
		}
		
		return res.substring(0, res.length() - 3);
	}

}
