public static void isPrime(int number)
    {
        for ( int i = 2; i<Math.sqrt(number) + 1; i ++)
        {
            if ( number%i==0 ) {//If number is not a prime
                //Will print that the number is not a prime once
                System.out.println(number +" is not a prime number.");
                return ; //Will exit the method
            }
        }
        //If you reach this point then the number is prime.
        System.out.println(number +" is a prime number.");
    }