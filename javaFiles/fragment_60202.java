double numberOne = 0;
        double numberTwo = 0;
        String operatorInput;
        Scanner myInput = new Scanner(System.in);

       System.out.print("Enter first number: ");
       numberOne = myInput.nextDouble();

       System.out.print("Enter second number: ");
       numberTwo = myInput.nextDouble();

       System.out.print("Enter the operation you wish to perform (/, *, -, +): ");
       operatorInput = myInput.nextLine();

       double result = calculate(numberOne, numberTwo, operatorInput, myInput);

       System.out.printf("The result is: %.2f%n", result);

       myInput.close();
    }

    public static double calculate(double numberOne, double numberTwo, String operatorInput, Scanner myInput)
    {
        while(true)
        {
            switch (operatorInput)
            {
                case("/"):
                {
                    myInput.close();
                    return divideNumbers(numberOne, numberTwo);
                }
                case("*"):
                {
                    myInput.close();
                    return multiplyNumbers(numberOne, numberTwo);
                }
                case("+"):
                {
                    myInput.close();
                    return addNumbers(numberOne, numberTwo);
                }
                case("-"):
                {
                    myInput.close();
                    return subtractNumbers(numberOne, numberTwo);
                }
                default: 
                {
                    System.out.println("Invalid Input");
                    System.out.print("Enter the operation you wish to perform (/, *, -, +): ");
                    operatorInput = myInput.nextLine();
                }
            }
        }
    }