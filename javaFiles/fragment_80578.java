Scanner keysIn = new Scanner(System.in);
for (int x =1; x>0; x++)
    //Infinite loop to be exited when user quits
{
    System.out.println("I'm thinking of a number between 1 and 100.");
    System.out.println("What is it?");
    int num = (int) (Math.random()*100+1);
    //Generate Random number between 1 and 100
    Outer: //Name loop for breaking later on
    while(true)
    {
        int num2 = keysIn.nextInt();
        // initialize the variable num2 and set it to next integer input
        System.out.println("Guess:" + num2);

        if (num == num2) 
            //If the generated number is equal to the guess
        {
            System.out.println("You go it!");
            System.out.println("Play Again? (Y = 1/N = 0)");
            Scanner scan = new Scanner(System.in);
            String desc = scan.nextLine();
            switch (desc){
            case "Y":
            case "Yes":
                break Outer;
            case "N":
            case "No":
                System.out.println("Thanks for playing");
                return;
            } 
        }
        else if(num > num2){
            System.out.println("Too Low.");
            //If the number generated is greater than the guessed number print "Too Low"        
        }
        else if (num <num2){
            System.out.println("Too High.");
            //If the number generated is less than the guessed number print "Too High"         
        }
    }
}