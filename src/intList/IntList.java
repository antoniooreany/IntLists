package intList;

import auxiliary.ListException;

public class IntList {

    private class IntListElement {
        private int info;
        private IntListElement next;

        IntListElement(int info, IntListElement next) {
            this.info = info;
            this.next = next;
        }

    }

    private IntListElement first;
    private IntListElement last;

    public IntList() {
        first = null;
        last = null;
    }

    boolean isEmpty() {
        return first == null;
    }

    void insertFirst(int newValue) {
        first = new IntListElement(newValue, first);
        if (last == null) last = first;
    }

    void insertLast(int newValue) {
        if (isEmpty())
            insertFirst(newValue);
        else
            last = (last.next = new IntListElement(newValue, null));
    }

    void deleteFirst() {
        if (isEmpty()) throw new ListException();
        first = first.next;
        if (first == null) last = null;
    }

    void deleteLast() {
        if (isEmpty()) throw new ListException();
        if (first == last) {
            first = null;
            last = null;
            return;
        }
        IntListElement prev = first;
        while (prev.next != last) {
            prev = prev.next;
        }
        last = prev;
        last.next = null;

    }

    int firstElement() {
        if (isEmpty()) throw new ListException();
        return first.info;
    }

    int lastElement() {
        if (isEmpty()) throw new ListException();
        return last.info;
    }

    int size() {
        int res = 0;
        for (IntListElement frog = first; frog != null; frog = frog.next)
            ++res;
        return res;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof IntList)) return false;
        IntList anotherIntList = (IntList) obj;
        if (size() != anotherIntList.size()) return false;

        IntListElement elem = first;
        IntListElement anotherElem = anotherIntList.first;
        while (elem != null) {
            if (elem.info != anotherElem.info) return false;
            elem = elem.next;
            anotherElem = anotherElem.next;
        }
        return true;
    }

    public String toString() {
        if (isEmpty()) return "";

        StringBuilder builder = new StringBuilder();

        for (IntListElement frog = first; frog != null; frog = frog.next)
            builder.append(frog.info).append(" / ");

        return builder.substring(0, builder.length() - 3);
    }

}
