package ru.vsu.cs.PoryadinAV;

public interface SimpleQueue<T> {
    void add(T var1);

    T remove() throws Exception;

    T element() throws Exception;

    int count();

    boolean empty();
}
