package ru.vsu.cs.PoryadinAV;

public class QueueReversing {
    public void reverseQueue(SimpleQueue<String> queue, SimpleQueue<String> reversedQueue) throws Exception {
        String temp = queue.remove();
        if (!queue.empty()) {
            reverseQueue(queue, reversedQueue);
        }
        reversedQueue.add(temp);
    }
}
