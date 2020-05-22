import java.util.*;
public class Test {
      public static void main(String[] args) { 
      Stack<String> myStack = new Stack<String>();
      String str = "<<test<> = 1 <><>";
      int count=0;
      char[] chs = str.toCharArray();    
          for(char ch: chs){
            if(ch == '<'){
                myStack.push(String.valueOf(ch));               
            }
            if( !myStack.isEmpty() & (ch == '>')){
                myStack.pop();
                count++;
            }
          }
      System.out.println("count = "+count); 

      }
    }