int inputStorage;
boolean notGuessed = true;
while(notGuessed)
{
    if(input.hasNextInt()){
         inputStorage = input.nextInt();
     } else{
         System.out.println("invalid type");
      }
    if (inputStorage == number) {
        System.out.println("You've guessed the right number!");
        notGuessed = false;
    }
    else if (inputStorage != number) {
        System.out.println("Wrong number, try again!");

    }
 }