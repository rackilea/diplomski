private static boolean promptForContinue(final Scanner keyboard)
 {
    do
    {
     System.out.print("Continue (Yes/No) ?");
     final String userInput = keyboard.next().toLowerCase();

     switch(userInput)
     {
       case "y":
       case "yes": return true;
       case "n": 
       case "no": return false;
       default : 
         System.out.println("Invalid Entry.");
     }
   }
   while (true);
 }