public class StackNode<T> 
{

    public T value;
}

public class Stack<T> 
{
    private int size;
    private int capacity;
    private int topNodeIndex;

    private StackNode<T>[] theStack;
}