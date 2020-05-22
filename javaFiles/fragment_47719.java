import java.util.*;
public class numbers{

  public static void main(String args[]){;
    Scanner input=new Scanner (System.in);

    int runs=0;
    int highestCount=0;
    int highestValue=0;

    System.out.println("please Enter 10 numbers:");
    while (runs<10){
      int inputValue=input.nextInt();

      if ( inputValue>highestValue){
        highestValue=inputValue;
        highestCount = 1;
      }

      else if(inputValue==highestValue){
        highestCount++;
      }
    }
    System.out.println("the biggest value is: "+highestValue+" and it is occurs "+highestCount+" times");
  }
}