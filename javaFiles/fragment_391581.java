import java.util.Scanner;

public class Histogram
{
  public static void main( String[] args)
  {
    Scanner scan = new Scanner( System.in);

    // Constant

    final String CH = "*";



   int count = 0;
    int number = 0;
    int start = 1;
    int width = 0;
    int line = 0;
    String output = "";
    String store="";


    // Creating the loop

    while ( start == 1) 
    {
      System.out.println( "Enter the numbers");
      number = scan.nextInt();

      if ( number < 0 )
      {
        start = 0;
      }

      else
      {  
        while ( width < number)
        {
         output = CH + " " ;
         width = width + 1  ;  
        store+=output;
        }
        width = 0;


      }
    }
    System.out.print(store);

  }
}