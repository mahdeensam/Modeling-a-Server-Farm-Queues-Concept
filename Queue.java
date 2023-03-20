public interface Queue<T> extends Iterable<T> {

    // This operation offers the given item into the queue
    // this means, its inserted at the end of the queue
    public void offer(T item);

    // This operation takes whatever item is next up from the queue
    public T poll();

    // This operation tells me the next item to be polled
    public T peek();

    // Returns the number of items in the queue
    public int size();
}
