do{
        invalidInput=false;
        try{

        System.out.print("Please enter a positive value for the numerator: ");
        int numerator = keyboard.nextInt();

        System.out.print("Please enter a positive value for the denominator: ");
        int denominator = keyboard.nextInt();
        if(numerator<0 && denominator <0){
           throw new NegativeValueException();
         }else if (numerator >=0 && denominator >= 0){
        int quotient = numerator / denominator;
        System.out.println();
        System.out.print("The result of integer division is: ");
        System.out.println(quotient);
        System.out.println();
        }
        } catch(InputMismatchException e){
            System.out.println("Enter only numbers.");
            invalidInput = true;
        }catch(NegativeValueException e){
            System.out.println("no negative values.");
            invalidInput = true;
        }catch(ArithmeticException e){
            System.out.println("Division by zero.");
            invalidInput = true;
        }
        }while (invalidInput);