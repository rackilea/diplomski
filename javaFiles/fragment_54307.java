for(int i=0;;i++)
{
   System.out.println("Enter your guess: ");
   guess = scan.nextInt();
   System.out.println(answer);

   if (guess<answer && guess != 0)
       System.out.println("Your guess was too low! (0 to exit) ");
   else if (guess>answer)
       System.out.println("Your guess was too high!(0 to exit) "); 
   else if (guess==0){
       System.out.println("You excited the current round.");
       break;}
   else{ 
       System.out.println("Your guess was correct!\n");
       System.out.println("It took "+i+" guesses to get the answer");
       break;}
   }
}