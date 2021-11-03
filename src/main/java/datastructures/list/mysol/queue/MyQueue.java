package datastructures.list.mysol.queue;

import datastructures.list.exercise.queue.IQueue;
import datastructures.list.mysol.linkedlist.MyLinkedList;

public class MyQueue<E> implements IQueue<E> {

    MyLinkedList<E> list = new MyLinkedList<>();

    @Override
    public E enqueue(E elem) {
        list.add(list.size(), elem);
        return elem;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        return list.remove(0);
    }

    @Override
    public E peek() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        return list.get(0);
    }

    @Override
    public boolean isEmpty() {
        return list.size() == 0;
    }

    @Override
    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        MyQueue<Integer> stack = new MyQueue<>();
        System.out.println("Enqueueing numbers to queue (0 to 9)");
        for (int i = 0; i < 10; i++) {
            stack.enqueue(i);
        }
        System.out.println("Pop numbers from stack");
        while (!stack.isEmpty()) {
            System.out.println(stack.dequeue());
        }
    }
}
