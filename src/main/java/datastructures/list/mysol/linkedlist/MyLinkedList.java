package datastructures.list.mysol.linkedlist;

import datastructures.list.exercise.MyAbstractList;

import java.util.Arrays;

public class MyLinkedList<E> extends MyAbstractList<E> {
    private int size = 0;
    private Node<E> first;
    private Node<E> last; // Allows adding at then in O(1) instead of O(n)

    @Override
    public boolean add(E e) {
        // Can be done in lots of ways, for example adding at the beginning or in this case at the end
        addTail(e);
        return true;
    }

    @Override
    public boolean contains(Object o) {
        // If size == 0 then current is null and the while is never entered
        Node<E> current = first;
        while (current != null && !current.elem.equals(o)) {
            current = current.next;
        }
        return current != null;
    }

    @Override
    public boolean remove(Object o) {
        Node<E> current = first, prev = null;
        while (current != null && !current.elem.equals(o)) {
            prev = current;
            current = current.next;
        }
        if (current != null) {
            if (current == first) first = first.next; // Deleting first
            else {
                prev.next = current.next; // Deleting any other, prev can't be null as not deleting first
            }
            if (current == last) last = prev; // Deleting last
            size--;
            return true;
        }
        return false; // Not found
    }

    @Override
    public E get(int index) {
        return getNode(index).elem;
    }

    private Node<E> getNode(int index) {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException();
        Node<E> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    @Override
    public void add(int index, E e) {
        if (index == 0) addHead(e);
        else if (index == size) addTail(e);
        else addAt(index, e);
    }


    private void addTail(E e) {
        Node<E> newNode = new Node<>(e);
        if (size==0) { // If it is first element
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode; // Update tail
        size++;
    }

    private void addHead(E e) {
        Node<E> node = new Node<>(e);
        if (size==0) {
            last = node;
        } else {
            node.next = first;
        }
        first = node;
        size++;
    }

    private void addAt(int index, E e) {
        Node<E> node = new Node<>(e);
        Node<E> prev = getNode(index - 1);
        node.next = prev.next;
        prev.next = node;
        size++;
    }

    @Override
    public E remove(int index) {
        E deleted = get(index);
        if (index == 0) {
            first = first.next;
            if (size == 1) last = null;
        } else {
            Node<E> prev = getNode(index - 1);
            prev.next = prev.next.next;
            if (index == size - 1) last = prev;
        }
        size--;
        return deleted;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int index = 0;
        Node<E> current = first;
        while (current != null) {
            array[index++] = current.elem;
            current = current.next;
        }
        return array;
    }

    @Override
    public int size() {
        return size;
    }

    private static class Node<E> {
        private final E elem;
        private Node<E> next;

        private Node(E elem) {
            this.elem = elem;
        }

        private Node(E elem, Node<E> next) {
            this.elem = elem;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(Arrays.toString(list.toArray()));
    }
}
