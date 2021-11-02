package datastructures.list.mysol.stack;

import datastructures.list.exercise.stack.IStack;
import datastructures.list.mysol.linkedlist.MyLinkedList;

import java.util.EmptyStackException;

public class MyStack<E> implements IStack<E> {

    MyLinkedList<E> list = new MyLinkedList<>();

    @Override
    public E pop() {
        if (empty()) throw new EmptyStackException();
        return list.remove(list.size() - 1);
    }

    @Override
    public E push(E elem) {
        list.add(elem);
        return elem;
    }

    @Override
    public E peek() {
        if(empty()) throw new EmptyStackException();
        return list.get(list.size() - 1);
    }

    @Override
    public boolean empty() {
        return list.size() < 1;
    }

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<Integer>();
        System.out.println("Pushing numbers to stack (0 to 9)");
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        System.out.println("Pop numbers from stack");
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }
}
