package datastructures.list.mysol.queue;

import datastructures.list.exercise.queue.IQueue;
import datastructures.list.mysol.stack.MyStack;

public class QueueWithStacks<E> implements IQueue<E> {

    MyStack<E> in = new MyStack<>();
    MyStack<E> out = new MyStack<>();


    @Override
    public void enqueue(E elem) {
        in.push(elem);
    }

    @Override
    public E dequeue() {
        if (out.empty()) restack(in, out);
        return out.pop();
    }

    @Override
    public E peek() {
        if (out.empty()) restack(in, out);
        return out.peek();
    }

    @Override
    public boolean isEmpty() {
        return in.empty() && out.empty();
    }

    private void restack(MyStack<E> stack1, MyStack<E> stack2) {
        // Moves all elements from stack 1 to stack 2
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
    }

    @Override
    public int size() {
        return in.size() + out.size();
    }
}
