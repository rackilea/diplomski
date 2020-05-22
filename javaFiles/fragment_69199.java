int numAttempts = 0;
       do {
            System.out.print("Please enter a number: ");
            inputNumber = scan.nextInt();

            if (inputNumber > randomNumber)
                        System.out.println("That's too high!");
            if (inputNumber < randomNumber)
                        System.out.println("That's too low!");
   //       else { 
   //       guessingLimit--;
   //       System.out.println("Too bad! The number was " +randomNumber+ "!"); //Trying to have it print this timeout after 7 incorrect attempts
   //       break;
   //       }
          numAttempts++;
        } while (inputNumber != randomNumber && numAttempts < 7);

        if(inputNumber == randomNumber){
            System.out.println("That's right!"); 
        }else{
            System.out.println("Incorrect 7 attempts"); 
        }