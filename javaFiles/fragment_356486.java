public class QC3PrimeNumbers
{

    public static void main (String[] args)
    {
        System.out.println ("Here are the prime numbers: ");

        int numOfPrimes = 0; // counts the # of prime nums in your region

        // this loop will count up the number of prime numbers
        for (int index = 2; index < 100; index++)
        {
            boolean isPrime = true; // initially true, reset this every loop

            // for every number that can factor into the index number
            for (int i = 2; i < index; i++)
                // if a number is found that factors into it, it's not prime
                if (index % i == 0) isPrime = false;

            if (isPrime) // if this number is prime
                numOfPrimes++; // add it to the count
        }

        // array to hold the prime nums w/ size=how many prime nums we counted
        int[] primeNums = new int[numOfPrimes];

        int count = 0; // keep track of the position in the primeNums array

        for (int index = 2; index < 100; index++)
        {
            boolean isPrime = true; // initially true, reset this every loop

            // for every number that can factor into the index number
            for (int i = 2; i < index; i++)
                // if a number is found that factors into it, it's not prime
                if (index % i == 0) isPrime = false;

            if (isPrime) // if this number is prime
            {
                primeNums[count] = index; // add this prime num to the array
                count++; // change the array position tracker for next number
            }
        }

        for (int n : primeNums) // for every integer in primeNums array
           System.out.print(n + " "); // display that integer to the console
    }
}