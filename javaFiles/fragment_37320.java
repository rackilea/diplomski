public class Stack {
    public int size ;                   // size = 0 at this time
    public Stack(int size)
    {
        this.size = size;
    }
    public int[] arr = new int[size];  // still size = 0 at this time!
                                       // so you're creating an array of size zero
                                       // (you won't be able to "put" any value in it)
    public int top = -1;

    //Methods
    public void push(int value)
    {
        top++;             // after this line `top` is 0
        arr[top] = value;  // in an array of zero size you are trying to set in its
                           // "zero" position the value of `value`
                           // it's something like this:
                           // imagine this array (with no more room)[], can you put values?,
                           // of course not
    }
}