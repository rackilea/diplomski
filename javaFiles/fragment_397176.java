public class Stack {

    private String[] stackArray;
    private int arraySize;
    private int top;

    public Stack(int capacity) {
        arraySize = capacity;
        stackArray = new String[arraySize];
        top = -1;
    }

    public void push(String i) {
        stackArray[++top] = i;
    }

    public String pop() {
        return stackArray[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == arraySize - 1;
    }
}