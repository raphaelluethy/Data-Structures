package datastructures.arraycollections.mysol;

import datastructures.arraycollections.excercise.AbstractArrayCollection;

import java.util.Arrays;
import java.util.Set;

public class SortedSet<E extends Comparable<? super E>> extends AbstractArrayCollection<E> implements Set<E> {
    public static final int DEFAULT_CAPACITY = 100;
    private final E[] data;
    private int size = 0;

    public SortedSet() {
        this(DEFAULT_CAPACITY);
    }

    public SortedSet(int capacity) {
        data = (E[]) new Comparable[capacity];
    }

    public static void main(String[] args) {
        SortedSet<Integer> bag = new SortedSet<Integer>();
        bag.add(2);
        bag.add(1);
        bag.add(2);
        System.out.println(Arrays.toString(bag.toArray()));
        System.out.println("SortedSet is sorted and does not allows the same value multiple times.");
        System.out.println("Bag contains 1: " + bag.contains(1));
        bag.remove(1);
        System.out.println(Arrays.toString(bag.toArray()));
    }

    @Override
    public boolean add(E e) {
        if (e == null) throw new NullPointerException();
        int index = getIndexOf(e);
        if (index >= 0) return false;
        if (size == data.length) throw new IllegalStateException("Collection is full!");
        index = -index - 1; // index becomes insertionPoint
        shiftRight(index);
        data[index] = e;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = getIndexOf(o);
        if (index >= 0) { // Exists
            shiftLeft(index);
            data[--size] = null; // Memory Leak cleanup
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return getIndexOf(o) >= 0;
    }

    private void shiftLeft(int index) {
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
    }

    private void shiftRight(int index) {
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
    }

    private int getIndexOf(Object o) {
        if (o == null) throw new NullPointerException();
        // Arrays.binarySearch returns index if found, otherwise (-(insertPosition) -1)
        // Where insertionPoint is the index of the first element larger then o.
        return Arrays.binarySearch(data, 0, size, o);
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
