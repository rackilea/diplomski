public class Stack {

    public int size;
    public int[] arr;         // declare the array variable, but do not initialize it yet
    public int top = -1;

    public Stack(int size) {
        this.size = size;
        arr = new int[size];  // when we know in advance which will be the size of the array,
                              // then initialize it with that size
    }

    //Methods
    public void push(int value) {
        top++;
        arr[top] = value;
    }
}