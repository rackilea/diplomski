Scanner keyboardInput = new Scanner(System.in);
    System.out.println("Enter a new pin between 1000 and 10000");
    double number1 = keyboardInput.nextInt();
    double number2 = 0;
    boolean bool=true;
    while (bool) {
    number2 = keyboardInput.nextInt();      
    if (number2> 1000 && number2 < 10000) {
         if(number1 == number2){                  
         System.out.println("Your pin is verified!"); 
         bool=false;
         }
         else{
          System.out.println("Please Re-enter the same pin");   
         }  
    }
    else{
    System.out.println("Pin should be between 1000 and 10000"); 
    }
 }