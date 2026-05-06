import java.util.Iterator;

import java.util.NoSuchElementException;


/**
 * Class to implement a singly linked list
 *
 * @author Radiah Khan 
 * @version Spring 2026
 */



//copy constructor 
//exception handle in a method
//


public class SLL<T> implements NodeBasedOps<T> {
    private NodeSL<T> head;
    private int size;

    //we are constructing the node and initiating the size to 0
    //initializing the head
    public SLL(){
        this.head= null;
        this.size = 0;
    }


    public SLL(SLL<T> other) {
        this.head = null;
        this.size = 0;
    NodeSL<T> curr = other.head;
    while (curr != null) {
        this.add(curr.getData());  
        curr = curr.getNext();
    }
}//because it was crashing for having no deep copy
    

    //helper 
    private NodeSL<T> nodeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }   
        NodeSL<T> curr = this.head;    
        for (int i = 0; i < index; i++) {
            curr = curr.getNext(); 
        }    
        return curr;
    }
    //tried to do the this.head=head ; didnt work

    /**
     * Returns true if the list is empty.
     * 
     * @return true if the size of list is 0, false otherwise
     */
    public boolean isEmpty(){
        return this.size== 0;
    }

    //ask hailie about it 

    /**
     * Gets the element at a given index.
     * 
     * @param index the index of the element we want
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range
     */

    //confused if it wants the node or the data
    public T get(int index) {
        NodeSL<T> node = nodeAt(index);  
        return node.getData();
    }



    public T add(T value) {
        add(size, value);
        return value;
    }

    // using a While loop to see if the head isnt there 
    //check for the tail  
    
    /**
     * Removes and returns the element at the specified index.
     * Shifts subsequent elements to the left.
     * 
     * @param index the position of the element to remove
     * @return the element that was removed
     * @throws IndexOutOfBoundsException if the index is out of range
     */


    //ask if i should get data or index 

    //ok again the logic is if i remove it then the updated node.prev will now connect it the updated node.next
    //edge case : 
            //i == 0, next node will become current head
            //list empty --> IllegalStateExeption 
    //will return the element fo the node so we have to save it somwhere

    
    public T remove(int index) {


            if (size == 0) {
                throw new IllegalStateException();
            }
            
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }
       
       

        if (index == 0) {
            T savedValue = this.head.getData();
            this.head = this.head.getNext();
            size--;
            return savedValue;
        }
        else {
            NodeSL<T> previousNode = nodeAt(index-1);
            T savedValue = previousNode.getNext().getData();
            //to skip over the node
            //took AI's help in this because could not figure it
            previousNode.setNext(previousNode.getNext().getNext());
            size --;
            return savedValue;

        }
        
        
    }
    /**
     * Returns the number of elements in the list.
     * 
     * @return the size of the list
     */
    public int size(){
        return this.size;
    }
    

    /**
     * Updates the value at the given index.
     * 
     * @param index the position of the element to update
     * @param value the new value to set at the index
     * @return the old value that was replaced
     * @throws IndexOutOfBoundsException if the index is out of range
     */

    //nodeAt
        //savedValue
        //setData(value)
        //return savedValue

    public T set(int index, T value){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        NodeSL<T> findNode = nodeAt(index);
        T savedValue = findNode.getData();
        findNode.setData(value);
        return savedValue;
    }   
    /**
     * Adds an element to the array at the given index.
     * 
     * @param index where we want to add the element
     * @param value the new element to add
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public void add(int index, T value) {

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        } 
        if (index == 0) {
            NodeSL<T> updatedNode = new NodeSL<>(value, this.head);
            this.head = updatedNode; //now we are just changing it to be the new node to b the head
            size ++;
             //referring to the prev node that was the head
        }
        else{
            NodeSL<T>previousNode = nodeAt(index-1);
            //we have .next() 
            NodeSL<T> updatedNode = new NodeSL<>(value, previousNode.getNext());
            previousNode.setNext(updatedNode);
            size ++;
        }
    }
// gets the index with the nodeAt 
// connects it to the next      
// creares a new node that points to the current head and update the pointer tbh
// we need to create a new node, and the current's next shud point to our new node instead of the node there was previousely an the new nde will connect to the ptev node
// edge cases: 
    // 1. OutOf Bound error 
    // 2. adding at begeining 
            // if(i = 0){
            //     new Node create
            //     then connect it to the prev head
            // }
    // 3. adding in last - it will point to null so the new.nextNode = null
    //4. In between
    /**
     * Returns a string representation of the list in the format [a, b, c].
     * An empty array returns "[]".
     * 
     * @return the string representation of the array in the format [a, b, c]
     */

    //Pseudocode/Process I am thinking :
        //get a while loop that loops thru until the head.next isnt null
        //edge case 1 : its empty so it will return []
        
        public String toString() {
            if (this.head == null) {
                return "[]";
            }        
            String firstString = "[";         
            NodeSL<T> curr = this.head;
            while (curr.getNext() != null) {
                firstString = firstString + curr.getData() + ", ";
                curr = curr.getNext();
            }      
            firstString = firstString + curr.getData() + "]";    
            return firstString;
        }
//Phase 2 
    /** 
     *  Accessor for head node
     *  @return the head node
     */
    public NodeSL<T> getHead(){
        return this.head;
    }
    
    /** 
     *  Accessor for tail node
     *  @return the tail node
     */

//edge cases :
        //if list == 0: (which is the size so if the head is null so the size is 0)
            //null is tail 
        
//while curr.getnext!=null:
//then we keep setting the current to its next so that it keeps updating
//when its outside the loop its goinh to return the last one
    
public NodeSL<T> getTail() {
    if (this.head == null) {
        return null;  
    }  
    NodeSL<T> curr = this.head;
    while (curr.getNext() != null) {
        curr = curr.getNext();
    }
    return curr;
}
  
    /** 
     *  Inserts the given item at the head of the list
     *  @param v item to insert 
     */
    public void addFirst(T v) {
        add(0, v);
    }
  
    /** 
     *  Inserts the given item at the tail of the list
     *  @param v item to insert 
     */
    public void addLast(T v){
        add(size, v);

    }
  
    /** 
     *  Removes the given item from the head of the list
     *  @return v item removed
     */
    public T removeFirst(){
        return remove(0);
    }
  
    /** 
     *  Removes the given item from the tail of the list
     *  @return item removed
     */
    public T removeLast(){
        return remove(size-1);
    }

  
    /** 
     *  Inserts the given item after the specified node.
     *  If here is null, insert at the head.
     *  @param here node to insert after
     *  @param v item to insert 
     */
    //edge case here is if the node that they asked to add is null so then the first node wil be the given 
public void addAfter(NodeSL<T> here, T v) {
    if (here == null) {
        addFirst(v);
        return;
    }
    NodeSL<T> nextNodeAfterGiven = new NodeSL<>(v, here.getNext());//we are grabbing the node after it
    here.setNext(nextNodeAfterGiven); 
    size++;
}

//     /** 
//      *  Removes the node after the given position.
//      *  If here is null, remove the head node.
//      *  @param here marks position to remove after
//      *  @return item removed
//      */
public T removeAfter(NodeSL<T> here) {  
    if (here == null) {
        return remove(0); //removing the head node 
    }
    T savedValueofNode = here.getNext().getData();//saving the data 
    here.setNext(here.getNext().getNext()); 
    size--;
    return savedValueofNode;  
}

  
//compile it in terminal java cla


public Iterator<T> iterator() {
    return new SLLIterator();

}
private class SLLIterator implements Iterator<T> {
    private NodeSL<T> curr; //created the node 
    private SLLIterator() {
        this.curr = head; //assigning curr variable to head 
    }
    public boolean hasNext() {
        if (curr.getNext() != null) { //ok was not working with just nexr 
            return true;
        } else {
            return false;
        }
    }
    public T next() {
        if (hasNext() == false) {
            throw new NoSuchElementException();
        } else {
            curr = curr.getNext();
            T data = curr.getData();
            return data;
        }
    }
}



//SplitCopy() 
//ask hailie 
    public SLL<T> splitCopy(int index){
        NodeSL<T> curr = this.head;
        //to copy from the index and so on
        for(int i=0; i< index ; i++){
            curr = curr.getNext(); //copies from 
        }
        SLL<T> newList = new SLL<T>();
        while(curr!=null){
            newList.addLast(curr.getData());
            curr = curr.getNext();

        }
        return newList;
}

  
//SplitTransfer() 

        //Pseudocode 
        //if we want to split it by [0] index
        //newList
        //curr.next points to head
        //curr.next points to null
        //A - B - C - D 
        //SplitTransfer(0)
        //head = A 
        //Have to disconnect B from A 
        //traverse to 0 (it will alwasyyyy start from 0)
        //starts from 0
        //starts from after the intended index (1)
        //curr.next = curr and sets the curr.prev = null

        public SLL<T> splitTransfer(int index) {
            NodeSL<T> curr = this.head;    
            for (int i = 0; i < index - 1; i++) {
                curr = curr.getNext();
            }
            NodeSL<T> modified = curr.getNext();
            curr.setNext(null);
            SLL<T> newList = new SLL<>();
            newList.head = modified; //did use generative ai here to understand how to keep on linking the nodes we have to a new list 
            return newList;
        }
    }
    
    
        

