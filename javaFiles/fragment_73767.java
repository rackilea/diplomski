import java.util.Scanner;

public class ReverseDigit
{
   public void reverseDigits()
 {
  Scanner input = new Scanner(System.in);
     System.out.print( "Please enter an integer number (other than -999 unless you wish to exit):");
     int number = input.nextInt();

     do
     {
        System.out.printf( "%d reversed is %d\n",
        number, toReverseDigits( number ) );

        System.out.print( "Enter an integer (-1 to exit): " );
        number = input.nextInt();

     }while(number>-1)


  }
     public int toReverseDigits ( int number)
     {
        int reverseNumber = 0; 
        int placeValue; 

        while ( number > 0 )
        {
           placeValue = number % 10;
           number = number / 10;
           reverseNumber = reverseNumber * 10 + placeValue;
        }
        return reverseNumber; 
     }
  }
  public class ReverseDigitsActive
  {
     public static void main( String args[] )
     {
        ReverseDigit application = new ReverseDigit();
        application.reverseDigits();
     }
  }