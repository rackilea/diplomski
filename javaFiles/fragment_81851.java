class Stack
{
private int maxSize;
private char[] stackArray;
private int top;
/**
 * Constructor for objects of class Stack
 */
    public Stack(int a)
    {
      maxSize = a;
      stackArray = new char [maxSize];
       top = -1;
    }

   public void push(char j)
   {
     top++;
     stackArray[top] = j;
   }  

   public char pop()
   {
     return stackArray[top--];
   }

   public int getSize(){
     return maxSize;
   }
}