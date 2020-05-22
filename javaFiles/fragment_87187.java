import java.util.Scanner;

public class SOQ5B
{

   public static boolean isPrime(int n) {

      for (int i = 2; i < n; i++) {
         if (n % i == 0) {
            return false;
         }
      }

      return true;
   }


   public static int nextPrime(int n) {
      n++;
      isPrime(n);
      while (isPrime(n) == false) {
         n++;
         isPrime(n);
      }
      int prime = n;
      return prime;
   }


/**
 * @param args the command line arguments
 */
   public static void main(String[] args) {
    // TODO code application logic here

      int answer;
      int counter = 0;
      int n;

      boolean playAgain = true;
      boolean isNum;
      boolean isNum2;
      boolean continuePermitted = true;

      Scanner input = new Scanner(System.in);

      String s;

      do {
        //ask for input
         System.out.print("\nEnter the integer value-> ");

         s = input.nextLine();


         isNum = true;

         for(int i = 0; i < s.length(); i++)
         {

            if(!(s.charAt(i) >= '0' && s.charAt(i) <= '9'))
            {

               isNum = false;

            }

         }

         if(isNum)
         {

            counter = 0;

            n = Integer.parseInt(s);

         //decide if prime
            if (isPrime(n)) {

            //display prime answer
               System.out.println(n + " Is Prime");

            //decide if even
            } 
            else {

            //display even answer
               System.out.println(n + " Is Even");

            }

         //counter input
            n++;

         //while input is false
            while (isPrime(n) == false) {
               n++;
            }


         //display next prime
            System.out.println(n + " Next prime");


            do
            {

               continuePermitted = true;

            //ask if you want to continue
               System.out.println("\nPlay Again?\n\nEnter 1)Yes or 2)No ");
            //input answer

               s = input.nextLine();

               isNum2 = true;

               for(int i = 0; i < s.length(); i++)
               {

                  if(!(s.charAt(i) >= '0' && s.charAt(i) <= '9'))
                  {

                     isNum2 = false;

                  }

               }


               if(isNum2)
               {

                  answer = Integer.parseInt(s);

               //if answer is 1)yes
                  if (answer == 1) {
                     playAgain = true;

                  //display play again and next input
                     System.out.println("\nPlay Again!");
                  }
               //if answer is no
                  if (answer == 2) {
                     playAgain = false;
                     System.out.println("\nGoodbye!");
                  //close program
                     System.exit(0);
                  }

               }

               else
               {

                  System.out.println("Incorrect response.");
                  continuePermitted = false;

                  //if answering the yes or no question incorrectly is part of the 3 strikes
                  //then uncomment the following lines of code

                  /*
                  counter++;
                  }

                  if(counter >= 3)
                  {

                  System.out.println("3 strikes you out");
                  System.exit(0);
                  */

               }
            }while(!continuePermitted);


         }

         else
         {

            System.out.print("\nIncorrect input. Number must be a positive integer.\n");
            counter++;

         }

         if(counter>=3)
         {

            System.out.println("3 strikes and you're out!");
            System.exit(0);

         }




      } while (playAgain != false);
   }
}