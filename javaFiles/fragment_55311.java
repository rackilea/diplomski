if (optionInt == 0) {
    System.out.println("Goodbye!"); 
    return;
} else {
    System.out.println("Enter the first number :");
    double num1 = scan.nextDouble();
    double num2 = 0;
    if (optionInt != 5) {
        System.out.println("Enter the second number :");
        num2 = scan.nextDouble();
    }
    double result;
    Action option = new Action();


    switch (optionInt) {
    case 1:
        result = option.addValues(num1, num2);
        option.displayResult(result);
        break;
    case 2:
        result = option.subtractValues(num1, num2);
        option.displayResult(result);
        break;
    case 3:
        result = option.multiplyValues(num1, num2);
        option.displayResult(result);
        break;  
    case 4:
        result = option.divideValues(num1, num2);
        option.displayResult(result);
        break;  
    case 5:
        result = option.squareValues(num1); // You will need to update your Action class
        option.displayResult(result);
        break;  
    case 6:
        result = option.modulusValues(num1, num2);
        option.displayResult(result);
        break;          
    default:
        System.out.println("You entered an incorrect option.  Goodbye.");
   } 

}