package datastructures.arraycollections.mysol;

import datastructures.arraycollections.AbstractArrayCollection;

import java.util.Arrays;

public class UnsortedBag<E> extends AbstractArrayCollection<E> {
    public static final int DEFAULT_CAPACITY = 100;
    private final E[] data;
    private int size = 0;

    public UnsortedBag() {
        this(DEFAULT_CAPACITY);
    }

    public UnsortedBag(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public static void main(String[] args) {
        UnsortedBag<Integer> bag = new UnsortedBag<Integer>();
        bag.add(2);
        bag.add(1);
        bag.add(2);
        System.out.println(Arrays.toString(bag.toArray()));
        System.out.println("UnsortedBag is not sorted and allows the same value multiple times.");
        System.out.println("Bag contains 1: " + bag.contains(1));
        bag.remove(1);
        System.out.println(Arrays.toString(bag.toArray()));
    }

    @Override
    public boolean add(E e) {
        if (e == null) throw new NullPointerException();
        if (size == data.length) throw new IllegalStateException("Collection is full!");
        data[size++] = e;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = getFirstIndexOf(o);
        if (index == -1) return false; // No need to check if size == 0 as then firstIndexOf would return -1
        // Replace to be deleted with the last element
        data[index] = data[size - 1]; // If index is last index this just overwrites itself
        data[--size] = null; // Memory Leak cleanup
        return true;
    }

    private int getFirstIndexOf(Object o) {
        if (o == null) throw new NullPointerException();
        for (int i = 0; i < size; i++) {
            if (data[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Object o) {
        // Check whether o is null is done in the getFirstIndexOf()
        return getFirstIndexOf(o) >= 0;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(data, size());
    }

    @Override
    public int size() {
        return size;
    }
}
