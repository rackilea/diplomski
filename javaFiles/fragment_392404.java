while (countOdd <= n) {

        if (counter % 2 != 0) {
            // Even term odd number
            if (countOdd % 2 == 0) {
                int factorial = factorial(counter);
                System.out.println("factorial: " + factorial);
                sinx = sinx - (Math.pow(x, counter) / factorial);
                System.out.println(" counter even odd term  = " + countOdd);
                countOdd++;
                System.out.println(" sinx  = " + sinx);
            }
            // Odd term odd number
            else {
                int factorial = factorial(counter);
                System.out.println("factorial: " + factorial);
                sinx = sinx + (Math.pow(x, counter) / factorial);
                System.out.println(" counter odd odd term  = " + countOdd);
                countOdd++;
                System.out.println(" sinx  = " + sinx);
            }
        }