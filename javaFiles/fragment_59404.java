while (answer.equals("Y"))
  {
     System.out.println("Would you like to find the Fibonaci number of another number?(Y/N)");
     answer = in.next(); //declare your variable answer outside the loop so you  can use it in the evaluation of how many times to do the loop.
  if (answer.equalsIgnoreCase("Y"))
  {
   System.out.println("What number would you like to find the Fibonacci number for?");
   x = in.nextInt();
   System.out.println("The Fibonacci number for " + x + " is " + calcFibNum(x));
   continue; // continue your loop without executing any further statements
  }
  else if (answer.equalsIgnoreCase("N"))
     System.out.println();
     break ; // break the loop and 
  }