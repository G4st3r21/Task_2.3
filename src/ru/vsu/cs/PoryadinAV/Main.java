package ru.vsu.cs.PoryadinAV;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        QueueReversing reversing = new QueueReversing();
        SimpleQueue<String> queue = new SimpleLinkedListQueue<>();

        int length = inputListLength();
        boolean isRandom = inputRandomQuestion();
        setIntegers(queue, length, isRandom);

        System.out.println("Сгенерированная очередь:");
        queue = printQueue(queue, length);

        SimpleQueue<String> newQueue = new SimpleLinkedListQueue<>();
        reversing.reverseQueue(queue, newQueue);

        System.out.println("Обратная очередь:");
        printQueue(newQueue, length);
    }

    public static int inputListLength() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите длину очереди: ");

        return scanner.nextInt();
    }

    public static boolean inputRandomQuestion() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Заполнить очередь случайным образом(True) или последовательно(False)?: ");

        return scanner.nextBoolean();
    }

    public static void setIntegers(SimpleQueue<String> queue, int range, boolean isRandom) {
        Random random = new Random();

        for (int i = 0; i < range; i++) {
            if (isRandom) {
                int tempInteger = random.nextInt(range);
                queue.add(Integer.toString(tempInteger));
            } else {
                queue.add(Integer.toString(i));
            }
        }
    }


    public static SimpleQueue<String> printQueue(SimpleQueue<String> queue, int length) throws Exception {
        SimpleQueue<String> tempQueue = new SimpleLinkedListQueue<>();
        for (int i = 0; i < length; i++) {
            String temp = queue.remove();
            System.out.print(temp);
            System.out.print(" ");
            tempQueue.add(temp);
        }
        System.out.println();

        return tempQueue;
    }
}
