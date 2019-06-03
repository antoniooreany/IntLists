package Kratzer.intSortedList;

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
		if (backfrog != null) {
			backfrog.next = new ListElement(newValue, frog);
			if (frog == null) 
				last = backfrog.next;
		} else {
			first = new ListElement(newValue, first);
			if (last == null)
				last = first;
		}
	}
		
	public void delete(int value) {
		
		if (isEmpty()) throw new ListException();
		
		// find insertion point
		ListElement frog;
		ListElement backfrog;
		
		for (frog = first, backfrog = null; 
			 frog != null && frog.info < value; 
			 backfrog = frog, frog = frog.next);
		
		// Have we found a value to kill?
		if (frog == null || frog.info != value)
			return;
		
		// Kill the value // TODO For sure: frog.info == value
//		while (frog != null && frog.info == value) { // All the elements with info = value are deleted.
			if (backfrog != null) {
				backfrog.next = frog.next;
				if (backfrog.next == null)
					last = backfrog;
			} else {
				first = first.next;
				if (first == null)
					last = null;
			}
			frog = frog.next;
		}
//	}
	
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
