do{
     try
     {
         System.out.println("Enter height in feet:");
         int feet=scanner.nextInt();
         System.out.println("and in inches:");
         int inches = scanner.nextInt();
         double result = height(feet,inches);
         System.out.println("Result:"+result+" cm");
         continueLoop = false;
     }
     catch(InputMismatchException e){
         System.out.println("You must enter integers. Please try again.");
         scanner.nextLine();
     }
     catch(Exception e){
         System.out.println(e.getMessage());
         scanner.nextLine();
     }
 }while(continueLoop);