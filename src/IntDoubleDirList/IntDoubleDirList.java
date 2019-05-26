package IntDoubleDirList;

import auxiliary.ListException;

public class IntDoubleDirList {

    private class IntListElement {
        private IntListElement prev;
        private int info;
        private IntListElement next;

        IntListElement(IntListElement prev, int info, IntListElement next) {
            this.prev = prev;
            this.info = info;
            this.next = next;
        }
    }

    private IntListElement first;
    private IntListElement last;

    IntDoubleDirList() {
        first = null;
        last = null;
    }

    boolean isEmpty() {
        return first == null;
    }

    void insertFirst(int newValue) {
        IntListElement newElem = new IntListElement(null, newValue, first);
        if (first == null) {
            first = newElem;
            last = newElem;
        } else {
            first.prev = newElem;
            first = newElem;
        }

    }

    void insertLast(int newValue) {
        IntListElement newElem = new IntListElement(last, newValue, null);
        if (first == null) {
            first = newElem;
            last = newElem;
        } else {
            last.next = newElem;
            last = newElem;
        }
    }

    void deleteFirst() {
        if (isEmpty()) throw new ListException();
        if (first == last) {
            first = null;
            last = null;
        } else {
            first.next.prev = null;
            first = first.next;
        }
    }

    void deleteLast() {
        if (isEmpty()) throw new ListException();
        if (first == last) {
            first = null;
            last = null;
        } else {
            last.prev.next = null;
            last = last.prev;
        }
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
        if (!(obj instanceof IntDoubleDirList)) return false;
        IntDoubleDirList anotherIntDoubleDirList = (IntDoubleDirList) obj;
        if (size() != anotherIntDoubleDirList.size()) return false;

        IntListElement elem = first;
        IntListElement anotherElem = anotherIntDoubleDirList.first;
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
