package umg.edu.gt.stack;

public class LinkedStack<T> {

    private Node<T> top;     
    private Node<T> bottom;   
    private int count;

    public void push(T value) {
        Node<T> newNode = new Node<>(value, top);
        top = newNode;
        if (bottom == null) bottom = newNode;
        count++;
    }

    public T pop() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        T value = top.getValue();
        top = top.getNext();
        count--;
        if (top == null) bottom = null;
        return value;
    }

    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return top.getValue();
    }

    public boolean isEmpty() {
        return count == 0;
    }

 
    public int getCount() { return count; }
    public int getSize()  { return count; }
    public int length()   { return count; }


    public Node<T> getNodeInit() {
        return bottom;
    }
}