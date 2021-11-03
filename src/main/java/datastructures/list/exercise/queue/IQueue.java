package datastructures.list.exercise.queue;

/**
 * Interface for Queue. See @see java.util.Queue
 */
public interface IQueue<E> {

    public abstract E enqueue(E elem);

    public abstract E dequeue();

    /**
     * {@link java.util.Queue#peek()}
     */
    public abstract E peek();

    /**
     * {@link java.util.Queue#isEmpty()}
     */
    public abstract boolean isEmpty();

    /**
     * {@link java.util.Queue#size()}
     */
    public abstract int size();
}