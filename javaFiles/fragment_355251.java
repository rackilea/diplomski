public void guessMyNumber()
{
  Random r = new Random();
  numToGuess = r.nextInt(MAX) + 1;
  Scanner input = new Scanner(System.in);
  String answer;
  do{

     System.out.println("Please guess a number between 1 and 10");
     userGuess = s.nextInt();

     while(userGuess != numToGuess)
     {
         if(userGuess < numToGuess)
         {
             System.out.println("too low; try again");
             userGuess = s.nextInt();
         }
         else if(userGuess > numToGuess){
             System.out.println("too high; try again");
             userGuess = s.nextInt();
         }
         else{
             System.out.println("wrong; try again!");
             userGuess = s.nextInt();
         }
     }
     System.out.println("Congratulations! You've won a quotation.");
     System.out.println("Do you want to continue ?(Yes/No)");
     System.out.println("Quotation is :"+numbersget(r.nextInt(numbers.size())));
     answer=input.next();
  }while((answer.equalsIgnoreCase("Yes")) 
}