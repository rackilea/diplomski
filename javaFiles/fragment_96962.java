double number = user.nextDouble();
   while (number != 1 && number != 2.50)
   {
       System.out.println("Not a valid number\n Try Again");
       number = user.nextDouble();
   }