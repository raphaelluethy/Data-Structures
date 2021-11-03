package datastructures.list.exercise.stack;

/**
 * Interface for Stack. See @see java.util.Stack
 */
public interface IStack<E> {
    /**
     * {@link java.util.Stack#pop()}
     */
    public abstract E pop();

    /**
     * {@link java.util.Stack#push()}
     */
    public abstract E push(E elem);

    /**
     * {@link java.util.Stack#peek()}
     */
    public abstract E peek();

    /**
     * {@link java.util.Stack#empty()}
     */
    public abstract boolean empty();

    /**
     * {@link java.util.Stack#size()}
     */
    public abstract int size();
}