package mysmallprograms;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;



/**

 * my project to build a calculator
 *
 */

    public class Calculator {
        public static int add(ArrayList<String> numbers)
        {   int sum=0;
            System.out.println("inside function add");
            if(numbers.isEmpty()==true)
                {System.out.println("empty string");
               }
            else
                {
                 System.out.println("String arraylist to be summed");
                 Iterator<String> it=numbers.iterator();

                 while(it.hasNext())
            {   int elem=Integer.parseInt(( it.next()));
                sum+=elem;
                System.out.println("calculating sum");
            }
        }
    return sum;

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner input= new Scanner(System.in);
        ArrayList<String> numbers= new ArrayList<String>();
        System.out.println("enter the numbers you want to add press enter after every number:");
        int num = Integer.parseInt(input.nextLine());
    try {
        while(num > 0 )
        { num--;
          String s=input.nextLine();
          System.out.println("adding element in arraylist");
          numbers.add(s);
        }
    }
       catch(Exception e) {
             System.out.println(e);
       }
        finally
        {
        System.out.println("calling calculator ");
        int sum=add(numbers);
        System.out.println("Sum of numbers : "+sum);
        }
    }


}