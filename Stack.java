public class Stack<T> implements StackADT<T> {
    //used ai to get the start from line 2-4
        private SLL<T> mySLL = new SLL<>();
    
    
    // we have addFirst() --> push in the SLL --> i did not see it before
    
        public void push(T other){
            mySLL.addFirst(other);
        }
    
        public T pop() {
            if (isEmpty()){
                throw new IllegalArgumentException("Stack is Empty");
            }
            T removed = mySLL.getHead().getData();        
            mySLL.removeFirst();
            return removed;
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
    
        public boolean isEmpty() {
            return mySLL.getHead() == null;
        }
    
    }