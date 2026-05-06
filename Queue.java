public class Queue<T> implements QueueADT<T> {
    private SLL<T> mySLL = new SLL<>();
    public void enqueue(T other){
        mySLL.addLast(other);
    }
    public T dequeue() {
        if (isEmpty()){
            throw new IllegalArgumentException("Stack Empty Nothing to Deque");
        }
        return mySLL.removeFirst();
    }
    public int size(){
        return mySLL.size();
    }
    public T peek(){
        if (isEmpty()){
            throw new IllegalArgumentException("Stack Empty No Peek");
        }
        return mySLL.getHead().getData();
    }
    public boolean isEmpty(){
        return mySLL.isEmpty();
    }

}
