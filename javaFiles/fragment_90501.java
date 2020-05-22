package arrayExceptionsWithInput;
import java.util.*;
public class InputException
{
public static void main(String[] args)
{
boolean error = false;
int firstInt;
int secondInt;
Scanner yourNumbers = new Scanner(System.in);
{
    do{
            try
            {

                    System.out.println(" please enter your first number");
                    firstInt = yourNumbers.nextInt();
                    yourNumbers.nextLine();
                    System.out.println(" pleas enter your second number");
                    secondInt = yourNumbers.nextInt();
                    yourNumbers.nextLine();
                    int finalInt = (firstInt+secondInt);
                    System.out.println("total is: " + finalInt);
                    yourNumbers.nextLine();

            }
            catch(InputMismatchException Q)
            {

                Q.printStackTrace();
                System.out.println(" one of your integers was incorrect, please try again");
                error = true;
                yourNumbers.nextLine();
            }   
        }while (error == true);
    }error = false;
}
}