package datastructures.arraycollections.mysol;

import datastructures.arraycollections.AbstractArrayCollection;

import java.util.Arrays;
import java.util.Set;

public class UnsortedSet<E> extends AbstractArrayCollection<E> implements Set<E> {
    public static final int DEFAULT_CAPACITY = 100;
    private final E[] data;
    private int size = 0;

    public UnsortedSet() {
        this(DEFAULT_CAPACITY);
    }

    public UnsortedSet(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public static void main(String[] args) {
        UnsortedSet<Integer> bag = new UnsortedSet<Integer>();
        bag.add(2);
        bag.add(1);
        bag.add(2);
        System.out.println(Arrays.toString(bag.toArray()));
        System.out.println("UnsortedSet is not sorted and does not allows the same value multiple times.");
        System.out.println("Bag contains 1: " + bag.contains(1));
        bag.remove(1);
        System.out.println(Arrays.toString(bag.toArray()));
    }

    @Override
    public boolean add(E e) {
        // Check whether e is null is done in the getIndexOf()
        if (contains(e)) return false;
        if (size == data.length) throw new IllegalStateException("Collection is full!");
        data[size++] = e;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = getIndexOf(o);
        if (index == -1) return false; // No need to check if size == 0 as then firstIndexOf would return -1
        // Replace to be deleted with the last element
        data[index] = data[size - 1]; // If index is last index this just overwrites itself
        data[--size] = null; // Memory Leak cleanup
        return true;
    }

    private int getIndexOf(Object o) {
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
        // Check whether o is null is done in the getIndexOf()
        return getIndexOf(o) >= 0;
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
