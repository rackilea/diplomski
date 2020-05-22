boolean shouldContinue = true;

while (shouldContinue == true){

    switch(Input.toLowerCase()) {

        case "earth":
            //calculate speed...

            System.out.print("\n \nEnter Yes for another calculation, else No: ");
            String Another = keyboard.next();
            Another.toLowerCase();

            //If the user inputs 'no', we change shouldContinue, that stops the loop from executing again
            if (Another.equals("no"){
                shouldContinue = false;
            }
        break;



         case "water":
            //calculate speed...

            System.out.print("\n \nEnter Yes for another calculation, else No: ");
            Another = keyboard.next();
            Another.toLowerCase();

            //If the user inputs 'no', we change shouldContinue, that stops the loop from executing again
            if (Another.equals("no"){
                shouldContinue = false;
            }
        break;

         case "steel":
            //calculate speed...

            System.out.print("\n \nEnter Yes for another calculation, else No: ");
            String Another = keyboard.next();
            Another.toLowerCase();

            //If the user inputs 'no', we change shouldContinue, that stops the loop from executing again
            if (Another.equals("no"){
                shouldContinue = false;
            } 
           break;     

        case "earth":
            //calculate speed...

            System.out.print("\n \nEnter Yes for another calculation, else No: ");
            String Another = keyboard.next();
            Another.toLowerCase();

            //If the user inputs 'no', we change shouldContinue, that stops the loop from executing again
            if (Another.equals("no"){
                shouldContinue = false;
            } 
       break;

        default :
            System.out.print("Invalid. Re-run the program. ");
            shouldContinue = false;    
        break;
   }
}