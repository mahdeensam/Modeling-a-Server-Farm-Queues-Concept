/* 
	File: LinkedList.java
	Author: Mahdeen Ahmed Khan Sameer
	Date: 03/05/2023
    CS231B
	creates list of objects with nodes for references
*/

import java.util.ArrayList;
import java.util.Iterator;

public class LinkedList<T> implements Iterable<T>, Queue<T> {

    private class Node<T> {
        // Class for the Node
        T data;
        Node<T> next;
        Node<T> prev;

        public Node(T data) {
            this(data, null);
        }

        public Node(T data, Node<T> next) {
            this(data, next, null);
        }

        public Node(T data, Node<T> next, Node<T> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

        public T getData() {
            return data;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }

        public Node<T> getNext() {
            return next;
        }

        public Node<T> getPrev() {
            return prev;
        }
    }

    private int size;

    private Node<T> head;
    private Node<T> tail;

    public LinkedList() {
        /*
         * Constructor for a LinkedList
         */
        size = 0;
        head = null;
        tail = null;
    }

    public ArrayList<T> toArrayList() {
        /*
         * Convert a LinkedList to an ArrayList
         */
        ArrayList<T> arr = new ArrayList<>();
        for (T i : this) {
            arr.add(i);
        }

        return arr;
    }

    public Iterator iterator() {
        /*
         * Return Iterator for the Iterable interface
         */
        return new LLIterator(head);
    }

    private class LLIterator implements Iterator<T> {

        Node<T> head;

        public LLIterator(Node<T> head) {
            /*
             * Constructor for Iterator
             */
            this.head = head;
        }

        public boolean hasNext() {
            /*
             * For the Iterator interface
             */
            if (head != null) {
                return true;
            }
            return false;
        }

        public T next() {
            /*
             * Next for iterator interface
             * Returns value of current next and moves to next
             */
            T temp = head.getData();
            head = head.next;
            return temp;
        }

        public void remove() {
            assert (true);
        }
    }

    public void add(T item) {
        /*
         * Add item to LinkedList
         */
        Node<T> newNode = new Node<T>(item, head);
        head = newNode;
        size++;
    }

    public int size() {
        // Return size of LinkedList
        return size;
    }

    public T get(int index) {
        /*
         * Get the data at a particular index
         */
        Node<T> walker = head;
        for (int i = 0; i < index; i++) {
            walker = walker.getNext();
        } // at the end of this loop, walker is at the final Node

        return walker.getData();
    }

    public void add(int index, T item) {
        /*
         * Add a particular item at a particular index in the LinkedList
         */
        if (index == 0) {
            add(item);
            return;
        }

        Node<T> walker = head;
        for (int i = 0; i < index - 1; i++) {
            walker = walker.getNext();
        }

        Node<T> temp = new Node<T>(item, walker.getNext());
        size++;
        walker.next = temp;
    }

    public void clear() {
        /*
         * Empty the LinkedList
         */
        head = null;
        size = 0;
    }

    public boolean contains(Object o) {
        /*
         * Check if a LinkedList contains an object o
         */
        for (T data : this) {
            if (data.equals(o)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object o) {
        /*
         * Check if two LinkedLists are equal
         */

        if (!(o instanceof LinkedList)) {
            return false;
        }
        // If I have reached this line, o must be a LinkedList
        LinkedList<T> oAsALinkedList = (LinkedList<T>) o;

        if (oAsALinkedList.size != size) {
            return false;
        }

        Node<T> d_walker = this.head;
        Node<T> o_walker = oAsALinkedList.head;
        for (int i = 0; i < size; i++) {
            if (!(d_walker.equals(o_walker))) {
                if (d_walker.getData().equals(o_walker.getData())) {
                    return true;
                }
                return false;
            }

            o_walker.getNext();
            d_walker.getNext();
        }
        return true;
    }

    public boolean isEmpty() {
        /*
         * Check if a LinkedList is empty
         */

        return head == null ? true : false;

    }

    /**
     * This method adds the given {@code data} to the start of the list.
     * 
     * @param data the data to be added into the list.
     */
    public void addFirst(T data) {
        if (head != null) {
            Node<T> temp = new Node<>(data, head, null);
            head.prev = temp;
            head = temp;
        } else {
            Node<T> temp = new Node<>(data);
            head = temp;
            tail = temp;
        }
        size++;
    }

    /**
     * This method adds the given {@code data} to the end of the list.
     * 
     * 
     * 
     */
    public void addLast(T data) {
        if (tail != null) {
            Node<T> temp = new Node<>(data, null, tail);
            tail.next = temp;
            tail = temp;
        } else {
            Node<T> temp = new Node<>(data);
            head = temp;
            tail = temp;
        }
        size++;
    }

    /**
     * This method returns and removes the first entry of the list.
     * 
     * @return the last entry of the list.
     */
    public T removeFirst() {
        // This return statement is only to let the code compile as is.
        // When you are ready, replace this return statement with the correct
        // value.
        if (head == null) {
            return null;
        }

        T res = head.getData();
        if (head.getNext() != null) {
            head = head.getNext();
            head.prev = null;
        } else {
            head = null;
            tail = null;
        }

        size--;
        return res;
    }

    /**
     * This method returns and removes the last entry of the list.
     * 
     * @return the last entry of the list.
     */
    public T removeLast() {
        if ((tail == null) || (head == null)) {
            return null;
        }

        T res = tail.getData();
        if (tail.prev != null) {
            tail = tail.prev;
            tail.next = null;
        } else {
            head = null;
            tail = null;
        }

        size--;
        return res;
    }

    public T remove() {
        /*
         * Remove head
         * Return data in head
         */
        Node<T> dummy = head;
        head = head.next;

        return dummy.getData();
    }

    public T remove(int index) {
        /*
         * Remove Node at a particular index
         */
        if (index == 0) {
            return remove();
        }

        Node<T> walker = head;
        for (int i = 0; i < index - 1; i++) {
            walker = walker.getNext();
        }

        Node<T> dummy = walker.next;
        walker.next = walker.next.next;

        return dummy.getData();
    }

    @Override
    public void offer(T item) {
        addLast(item);
    }

    @Override
    public T poll() {
        return removeFirst();
    }

    @Override
    public T peek() {
        if (head == null) {
            return null;
        }
        return head.getData();
    }

    public String toString() {
        /*
         * String representation of a LinkedList
         */
        String res = "[";
        Node<T> walker = head;

        if (size == 0) {
            return "[]";
        }

        for (int i = 0; i < size - 1; i++) {
            res += walker.getData();
            res += ", ";

            walker = walker.getNext();
        }
        res += walker.getData() + "]";

        return res;
    }

}