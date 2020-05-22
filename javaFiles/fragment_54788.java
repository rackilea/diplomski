System.out.println( "enter two numbers:" );

try {
    int num1 = sc.nextInt();
    int num2 = sc.nextInt();

   System.out.println( num1+num2 );

}
catch(InputMismatchException e){
    System.out.println("Invalid Character");
}