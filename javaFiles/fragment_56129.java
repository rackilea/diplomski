import java.util.Arrays;
    import java.util.Scanner;

    public class ArrayTest 
    {
        Scanner input = new Scanner( System.in );

        int usersGuess;       
        int randomNumber = 45;
         int num_of_guesses = 0;

         int max_guesses = 20;


        public void enterNumbers()
        {
            int testArray []  = new int[ max_guesses ];

             do
            {


                  if ( usersGuess != randomNumber )
                {
                    System.out.printf("Please enter numbers: ");
                    usersGuess  = input.nextInt();     

                }
                else 
                      System.out.println("Correct guess");

                  testArray[ num_of_guesses ] = usersGuess;
                  num_of_guesses++;

                  if ( num_of_guesses >= max_guesses)
                {
                    System.out.println("Your all out of guesses!");
                    break;     
                } 

            } 
            while ( usersGuess != randomNumber &&  max_guesses >= num_of_guesses );

            System.out.println( "\nMiddle is: " + testArray
                    [ ( num_of_guesses)/ 2] );

            Arrays.sort( testArray, 0, num_of_guesses );


            System.out.println( "Median is: " + testArray[ ( num_of_guesses)/ 2 ] );
            System.out.println();

        }

    }

    public class Test 
    {
        public static void main( String [] args )
        {
            ArrayTest arrayTest = new ArrayTest();

            arrayTest.enterNumbers();
        }

    }