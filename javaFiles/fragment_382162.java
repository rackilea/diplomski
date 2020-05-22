for(int ii = 1, j = 0; j <= copySel ; ii++, j++) {  //btw, what is 'j' for? attempt count?
         boolean mode; //true = minimum, false = maximum
         boolean firstNumber = true;
         int check; //user input
         int lastValue; //will be the storage
            // Prompt as follows
            System.out.print("Enter value " + ii + ": ");
            try {
                c = Get();
            }
            catch (InputMismatchException e) {
                input
                System.out.println("Invalid input!");
                ii--;
            }
             check = c;
             if (firstNumber) { //first input has nothing to compare with
                 lastValue = check;
                 firstNumber = false;
                 continue;
             }
             lastValue = mode ? min(check, lastValue) : max(check, lastValue);
             /* you should also implement max() method if you want to be able to find maximum
             *  if you don't, just write lastValue = min(check, lastValue);
             *  and remove other 'mode' dependancies.
             */


             System.out.println((mode ? "minimum is: " : "maximum is: ") + String.valueOf(lastValue));

    }