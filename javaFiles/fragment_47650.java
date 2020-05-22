Scanner input = new Scanner(System.in);
int yaya = 5;
int x = 10;
int RoxasC = 0;
int DuterteC = 0;

do {
     System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
     System.out.println("Vote Ballot");
     System.out.println("Below are the 2 Canditates you can choose to vote from");
     System.out.println("Mar Roxas --- Code: 11");
     System.out.println("Duterte ---- Code: 12"); 
     System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
     System.out.println("Who do you vote? Enter numbers only!"); 
     int choice = input.nextInt();
     System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
     if (choice == 11) 
     {

         System.out.println("You have voted Mar Roxas and not Duterte");
         RoxasC++;

     }
     else if ( choice == 12 ) 
     {

         System.out.println("You have voted Duterte and not Mar Roxas");
         DuterteC++;

     }
     else 
     {

         System.out.println("You have entered an invalid number");

     }
     String confirm = "confirm";
     String deny = "deny";
     int conf = 1;
     int den = 2;
     System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
     System.out.println("Do you want to let another voter vote? Or would you like to end the program at hand?");

     int ans = input.nextInt();
     System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
     if ( ans==1 )
     {

         System.out.println("The program would now repeat");

     }
     else if ( ans==2 ) 
     {
          System.out.println("Mar Roxas received " +RoxasC+ " number of votes, and Duterte received " +DuterteC+ 
              " number of votes");

          System.out.println("Program will end as per request");
          yaya = 0;
          break;

     }
     else
     {
         System.out.println("You entered an invalid keyword program would still repeat");
     }

     System.out.println("\n");

} while( yaya==5 ); //Program Runs Infinitely