while(true){
System.out.print("Please enter a positive integer that is prime or not : ");
try{
   int i = input.nextInt();
   break;
}catch(InputMismatchException e){
   System.out.print("Wrong type input, pls try again!");
   input.nextLine(); \\ prevent infinite loop
}