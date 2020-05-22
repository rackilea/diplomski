import java.io.*;
 import java.util.EmptyStackException;
 import java.util.Vector;
 public class Stack extends Vector 
 {
   private Object a[];
   private int top;
   public void Stack() 
  {
    a=new Object[100];
    top=-1;
  }
  public void Stack(int n) 
  {
    a=new Object[n];
    top=-1;
  }
  public E pop() 
  {
    E   obj;
    int len = size();
    if (top == -1)
        throw new EmptyStackException();
    else
       obj=(E) a[top--]; 
    return obj;
  }
  public void push(E e) 
  {
    if(e==null)
        throw new NullPointerException();
    else if(top==size()-1)
        System.out.println("Stack full");
    else
    {
       a[++top]=e;
       System.out.println("pushed :"+e);
    }


}
public int size() 
{
    int i;
    for(i=0;a[i]!=null;i++);
    return i;
}
}