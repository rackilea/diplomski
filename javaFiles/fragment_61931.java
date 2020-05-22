while (score < 0 || score > 100) 
 {
   System.out.println("please enter a number between 0 and 100.");

        while(!scan.hasNextInt())
        {
             scan.next();
        }
      score = scan.nextInt();
  }