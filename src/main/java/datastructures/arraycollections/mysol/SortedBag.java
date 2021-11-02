package datastructures.arraycollections.mysol;

import datastructures.arraycollections.AbstractArrayCollection;

import java.util.Arrays;

public class SortedBag<E extends Comparable<? super E>> extends AbstractArrayCollection<E> {
    public static final int DEFAULT_CAPACITY = 100;
    private final E[] data;
    private int size = 0;

    public SortedBag() {
        this(DEFAULT_CAPACITY);
    }

    public SortedBag(int capacity) {
        data = (E[]) new Comparable[capacity];
    }

    public static void main(String[] args) {
        SortedBag<Integer> bag = new SortedBag<Integer>();
        bag.add(2);
        bag.add(1);
        bag.add(2);
        System.out.println(Arrays.toString(bag.toArray()));
        System.out.println("SortedBag is sorted and allows the same value multiple times.");
        System.out.println("Bag contains 1: " + bag.contains(1));
        bag.remove(1);
        System.out.println(Arrays.toString(bag.toArray()));
    }

    @Override
    public boolean add(E e) {
        if (e == null) throw new NullPointerException();
        if (size == data.length) throw new IllegalStateException("Collection is full!");
        int index = getIndexOf(e);
        index = index >= 0 ? index : -index - 1; // Index or if not found insertionPoint
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
