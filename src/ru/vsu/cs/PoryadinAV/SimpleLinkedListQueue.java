package ru.vsu.cs.PoryadinAV;

public class SimpleLinkedListQueue<T> extends SimpleLinkedList<T> implements SimpleQueue<T> {
    public SimpleLinkedListQueue() {
    }

    public void add(T value) {
        this.addLast(value);
    }

    public T remove() throws Exception {
        T result = this.element();
        this.removeFirst();
        return result;
    }

    public T element() throws Exception {
        if (this.empty()) {
            throw new Exception("Queue is empty");
        } else {
            return this.getFirst();
        }
    }

    public int count() {
        return this.size();
    }

    public boolean empty() {
        return this.count() == 0;
    }
}
