//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ru.vsu.cs.PoryadinAV;

import java.util.Iterator;

public class SimpleLinkedList<T> implements Iterable<T> {
    private SimpleLinkedListNode head = null;
    private SimpleLinkedListNode tail = null;
    private int size = 0;

    public void addFirst(T value) {
        this.head = new SimpleLinkedListNode(value, this.head);
        if (this.size == 0) {
            this.tail = this.head;
        }

        ++this.size;
    }

    public void addLast(T value) {
        if (this.size == 0) {
            this.head = this.tail = new SimpleLinkedListNode(value);
        } else {
            this.tail.next = new SimpleLinkedListNode(value);
            this.tail = this.tail.next;
        }

        ++this.size;
    }

    private void checkEmptyError() throws SimpleLinkedListException {
        if (this.size == 0) {
            throw new SimpleLinkedListException("Empty list");
        }
    }

    private SimpleLinkedListNode getNode(int index) {
        SimpleLinkedListNode curr = this.head;

        for(int i = 0; i < index; ++i) {
            curr = curr.next;
        }

        return curr;
    }

    public void removeFirst() throws SimpleLinkedListException {
        this.checkEmptyError();
        this.head = this.head.next;
        if (this.size == 1) {
            this.tail = null;
        }

        --this.size;
    }

    public void removeLast() throws SimpleLinkedListException {
        this.checkEmptyError();
        if (this.size == 1) {
            this.head = this.tail = null;
        } else {
            this.tail = this.getNode(this.size - 2);
            this.tail.next = null;
        }

        --this.size;
    }

    public void remove(int index) throws SimpleLinkedListException {
        this.checkEmptyError();
        if (index >= 0 && index < this.size) {
            if (index == 0) {
                this.removeFirst();
            } else {
                SimpleLinkedListNode prev = this.getNode(index - 1);
                prev.next = prev.next.next;
                if (prev.next == null) {
                    this.tail = prev;
                }

                --this.size;
            }

        } else {
            throw new SimpleLinkedListException("Incorrect index");
        }
    }

    public int size() {
        return this.size;
    }

    public T get(int index) throws SimpleLinkedListException {
        this.checkEmptyError();
        return this.getNode(index).value;
    }

    public T getFirst() throws SimpleLinkedListException {
        this.checkEmptyError();
        return this.head.value;
    }

    public T getLast() throws SimpleLinkedListException {
        this.checkEmptyError();
        return this.tail.value;
    }

    public Iterator<T> iterator() {
        class SimpleLinkedListIterator implements Iterator<T> {
            SimpleLinkedListNode curr;

            SimpleLinkedListIterator() {
                this.curr = SimpleLinkedList.this.head;
            }

            public boolean hasNext() {
                return this.curr != null;
            }

            public T next() {
                T value = this.curr.value;
                this.curr = this.curr.next;
                return value;
            }
        }

        return new SimpleLinkedListIterator();
    }

    private class SimpleLinkedListNode {
        public T value;
        public SimpleLinkedListNode next;

        public SimpleLinkedListNode(T value, SimpleLinkedListNode next) {
            this.value = value;
            this.next = next;
        }

        public SimpleLinkedListNode(T value) {
            this(value, (SimpleLinkedListNode)null);
        }
    }

    public static class SimpleLinkedListException extends Exception {
        public SimpleLinkedListException(String message) {
            super(message);
        }
    }
}
