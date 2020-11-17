package edu.touro.mco264;

import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MyDoublyLinkedListTest {
    MyDoublyLinkedList mll = new MyDoublyLinkedList();

    @org.junit.jupiter.api.Test
    void size() {
        assertEquals(0, mll.size());
    }

    @org.junit.jupiter.api.Test
    void equals() {
        ArrayList<String> al = new ArrayList<String>();
        al.add("A");
        al.add("B");

        mll.addAll(al);
        MyDoublyLinkedList mll2 = new MyDoublyLinkedList(al);

        assertTrue(mll.equals(mll2));

        mll2.add("C");
        assertFalse(mll.equals(mll2));

        mll.add("D");
        assertFalse(mll.equals(mll2));
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        assertTrue(mll.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void contains() {
        mll.add("A");
        mll.add("B");

        assertTrue(mll.contains("A"));
        assertFalse(mll.contains("C"));
    }

    @org.junit.jupiter.api.Test
    void iterator() {
        mll.add("A");
        mll.add("B");
        mll.add("C");

        for (String s : mll) {
            System.out.println(s);
        }
    }

    @org.junit.jupiter.api.Test
    void toArray() {
    }

    @org.junit.jupiter.api.Test
    void testToArray() {
    }

    @org.junit.jupiter.api.Test
    void add() {
        mll.add("A");

        assertEquals("A", mll.get(0));
    }

    @org.junit.jupiter.api.Test
    void remove() {
    }

    @org.junit.jupiter.api.Test
    void containsAll() {
        ArrayList<String> al = new ArrayList<String>();
        al.add("A");
        al.add("B");
        al.add("C");

        mll.add("A");
        mll.add("B");
        mll.add("C");

        assertTrue(mll.containsAll(al));

        mll.remove(1);
        assertFalse(mll.containsAll(al));
    }

    @org.junit.jupiter.api.Test
    void addAll() {
        ArrayList<String> al = new ArrayList<String>();
        al.add("A");
        al.add("B");
        al.add("C");

        assertTrue(mll.addAll(al));
        assertEquals("C", mll.get(2));
        assertEquals(3, mll.size());

        al.clear();
        assertFalse(mll.addAll(al));
    }

    @org.junit.jupiter.api.Test
    void addAllIndex() {
        ArrayList<String> al = new ArrayList<String>();
        al.add("X");
        al.add("Y");
        al.add("Z");

        mll.add("A");
        mll.add("B");
        mll.add("C");
        assertTrue(mll.addAll(1, al));
        assertEquals("Y", mll.get(2));
        assertEquals(6, mll.size());

        al.clear();
        assertFalse(mll.addAll(1, al));
    }

    @org.junit.jupiter.api.Test
    void removeAll() {
        mll.add("A");
        mll.add("B");
        mll.add("C");

        ArrayList<String> al = new ArrayList<String>();
        al.add("A");
        al.add("D");

        mll.removeAll(al);

        for (String s : mll) {
            System.out.println(s);
        }
        assertEquals(2, mll.size());
    }

    @org.junit.jupiter.api.Test
    void retainAll() {
        mll.add("A");
        mll.add("B");
        mll.add("C");

        ArrayList<String> al = new ArrayList<String>();
        al.add("B");
        al.add("C");

        mll.retainAll(al);

        for (String s : mll) {
            System.out.println(s);
        }
        assertEquals(2, mll.size());
    }

    @org.junit.jupiter.api.Test
    void clear() {
        mll.add("A");
        mll.clear();

        assertEquals(0, mll.size());
    }

    @org.junit.jupiter.api.Test
    void get() {
        //Tested with the add method
    }

    @org.junit.jupiter.api.Test
    void getFirst() {
        mll.add("A");
        mll.add("B");

        assertEquals("A", mll.getFirst());
    }

    @org.junit.jupiter.api.Test
    void getLast() {
        mll.add("A");
        mll.add("B");

        assertEquals("B", mll.getLast());
    }

    @org.junit.jupiter.api.Test
    void set() {
        mll.add("A");

        assertEquals("A", mll.set(0, "B"));
        assertEquals("B", mll.get(0));
    }

    @org.junit.jupiter.api.Test
    void addIndex() {
        mll.add("A");
        mll.add(0, "B");

        assertEquals("B", mll.get(0));
    }

    @org.junit.jupiter.api.Test
    void addFirst() {
        mll.add("A");
        mll.addFirst("B");

        assertEquals("B", mll.get(0));
    }

    @org.junit.jupiter.api.Test
    void addLast() {
        mll.add("A");
        mll.addLast("B");

        assertEquals("B", mll.get(1));
    }

    @org.junit.jupiter.api.Test
    void removeIndex() {
        mll.add("A");
        mll.add("B");
        mll.add("C");

        mll.remove(1);

        assertEquals("C", mll.get(1));
    }

    @org.junit.jupiter.api.Test
    void removeEmpty() {
        mll.add("A");
        mll.add("B");
        mll.add("C");

        mll.remove();

        assertEquals("B", mll.get(0));
    }

    @org.junit.jupiter.api.Test
    void removeFirst() {
        mll.add("A");
        mll.add("B");
        mll.add("C");

        mll.removeFirst();

        assertEquals("B", mll.get(0));
    }

    @org.junit.jupiter.api.Test
    void removeLast() {
        mll.add("A");
        mll.add("B");
        mll.add("C");

        assertEquals("C", mll.removeLast());
    }

    @org.junit.jupiter.api.Test
    void removeObject() {
        mll.add("A");
        mll.add("B");
        mll.add("C");

        mll.remove("A");

        assertEquals("B", mll.get(0));
    }

    @org.junit.jupiter.api.Test
    void removeFirstOccurrence() {
        mll.add("A");
        mll.add("B");
        mll.add("A");
        mll.add("C");

        mll.removeFirstOccurrence("A");

        assertEquals("A", mll.get(1));
    }

    @org.junit.jupiter.api.Test
    void removeLastOccurrence() {
        mll.add("A");
        mll.add("B");
        mll.add("A");
        mll.add("C");

        mll.removeLastOccurrence("A");

        assertEquals("A", mll.get(0));
    }

    @org.junit.jupiter.api.Test
    void indexOf() {
        mll.add("A");
        mll.add("B");
        assertEquals(1, mll.indexOf("B"));
    }

    @org.junit.jupiter.api.Test
    void lastIndexOf() {
        mll.add("A");
        mll.add("A");
        assertEquals(1, mll.lastIndexOf("A"));
    }

    @org.junit.jupiter.api.Test
    void listIterator() {
    }

    @org.junit.jupiter.api.Test
    void testListIterator() {
    }

    @org.junit.jupiter.api.Test
    void subList() {
    }
}