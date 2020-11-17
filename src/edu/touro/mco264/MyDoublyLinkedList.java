package edu.touro.mco264;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyDoublyLinkedList implements List<String> {

    private Node head, tail;
    private int size;

    public MyDoublyLinkedList() {
        head = new Node();  //Dummy, cleans code
        tail = new Node();

        head.next = tail;
        tail.prev = head;
    }

    public MyDoublyLinkedList(Collection<? extends String> c) {
        this();
        addAll(c);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return !(indexOf(o) == -1);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for(Object o : c) {
            if(!contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Iterator<String> iterator() {
        return new MyDoublyLinkedListIterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(String s) {
        Node newNode = new Node();
        newNode.data = s;
        newNode.next = tail;
        newNode.prev = tail.prev;

        tail.prev.next = newNode;
        tail.prev = newNode;

        size++;
        return true;
    }

    @Override
    public void add(int index, String element) {
        checkIndexInRange(index, true);

        Node newNode = new Node();
        newNode.data = element;

        if (index == 0) {
            newNode.next = head.next;
            newNode.prev = head;

            head.next.prev = newNode;
            head.next = newNode;
        }
        else {
            Node spliceNode = getNode(index - 1);

            newNode.next = spliceNode.next; // newNode next must point to whatever followed the spliceNode
            newNode.prev = spliceNode;

            spliceNode.next.prev = newNode;
            spliceNode.next = newNode;
        }

        size++;
    }

    public void addFirst(String element) {
        add(0, element);
    }

    public void addLast(String element) {
        add(element);
    }

    @Override
    public boolean addAll(Collection<? extends String> c) {
        boolean changed = false;
        for(String s : c) {
            changed = add(s) || changed;
        }
        return changed;
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        Node spliceNode = getNode(index);
        boolean changed = false;

        for(String s : c) {
            Node newNode = new Node();
            newNode.data = s;
            newNode.next = spliceNode;
            newNode.prev = spliceNode.prev;

            spliceNode.prev.next = newNode;
            spliceNode.prev = newNode;
            changed = true;
        }

        size += c.size();
        return changed;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean changed = false;

        Iterator<String> listIterator = this.iterator();
        while(listIterator.hasNext()) {
            String listChecker = listIterator.next();
            for(Object s : c) {
                if(s.equals(listChecker)) {
                    listIterator.remove();
                    changed = true;
                    break;
                }
            }
        }

        return changed;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean changed = false;

        Iterator<String> listIterator = this.iterator();
        while(listIterator.hasNext()) {
            String listChecker = listIterator.next();
            boolean toremove = true;
            for(Object s : c) {
                if(s.equals(listChecker)) {
                    toremove = false;
                }
            }
            if(toremove) {
                listIterator.remove();
                changed = true;
            }
        }

        return changed;
    }

    @Override
    public void clear() {
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    @Override
    public String get(int index) {
        return getNode(index).data;
    }

    public String getFirst() {
        return getNode(0).data;
    }

    public String getLast() {
        return  getNode(size() - 1).data;
    }

    @Override
    public String set(int index, String element) {
        checkIndexInRange(index, false);

        Node setter = getNode(index);
        String old = setter.data;
        setter.data = element;

        return old;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if(index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    public String remove(int index) {
        checkIndexInRange(index, false);

        String removed;

        if(index == 0) {
            removed = head.next.data;
            head.next = head.next.next;
            head.next.prev = head;
        }
        else if(index == size() - 1) {
            Node lastNode = getNode(size() - 2);
            removed = lastNode.next.data;
            lastNode.next = tail;
            tail.prev = lastNode;
        }
        else {
            Node previousNode = getNode(index - 1);
            removed = previousNode.next.data;
            previousNode.next = previousNode.next.next;
            previousNode.next.prev = previousNode;
        }

        size--;
        return removed;
    }

    public String remove() {
        return remove(0);
    }

    public String removeFirst() {
        return remove(0);
    }

    public String removeLast() {
        return remove(size() - 1);
    }

    public boolean removeFirstOccurrence(Object o) {
        return remove(o);
    }

    public boolean removeLastOccurrence(Object o) {
        if(lastIndexOf(o) != -1) {
            remove(lastIndexOf(o));
            return true;
        }
        return false;
    }

    @Override
    public int indexOf(Object o) {
        Node finder = head.next;

        for(int i = 0; i < size(); i++) {
            if(finder.data.equals(o)) {
                return i;
            }
            finder = finder.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        Node finder = tail.prev;

        for(int i = size() - 1; i >= 0; i--) {
            if(finder.data.equals(o)) {
                return i;
            }
            finder = finder.prev;
        }
        return -1;
    }

    @Override
    public ListIterator<String> listIterator() {
        return null;
    }

    @Override
    public ListIterator<String> listIterator(int index) {
        return null;
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        return null;
    }

    void checkIndexInRange(int index, boolean isSizeLegal) {
        int maxLegalValue = isSizeLegal ? size() : size()-1;
        if (index > maxLegalValue || index < 0)
            throw new IndexOutOfBoundsException(String.format("Index [%d] is greater than maximum value [%d] List size [%d]", index, maxLegalValue, size()));
    }

    Node getNode(int index) {
        checkIndexInRange(index, false);
        Node finder = head.next;

        for (int i = 0; i < index; i++) {
            finder = finder.next;
        }
        return finder;
    }

    public boolean equals(Object o) {
        if(((MyDoublyLinkedList) o).size() == this.size()) {
            MyDoublyLinkedList comparison = (MyDoublyLinkedList) o;
            for(int i = 0; i < size; i++) {
                if(this.get(i) != comparison.get(i)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private static class Node
    {
        String data;
        Node next, prev;
    }

    private class MyDoublyLinkedListIterator implements Iterator<String> {
        Node tracker = head;
        boolean nextCalled;

        @Override
        public boolean hasNext() {
            return tracker.next != tail;
        }

        @Override
        public String next() {
            tracker = tracker.next;
            nextCalled = true;
            return tracker.data;
        }

        @Override
        public void remove() {
            if(!nextCalled)
                throw new IllegalStateException();

            tracker.prev.next = tracker.next;
            tracker.next.prev = tracker.prev;
            tracker = tracker.prev;

            size--;
            nextCalled = false;
        }
    }
}
