public class QC3PrimeNumbers
{

    public static void main (String[] args)
    {
        System.out.println ("Here are the prime numbers: ");

        // use a List to store your prime numbers (its size is dynamic)
        List<Integer> primeNums = new ArrayList<Integer>();

        for (int index = 2; index < 100; index++)
        {
            boolean isPrime = true; // initially true, and reset this every loop

            // for every number that can factor into the index number
            for (int i = 2; i < index; i++) 
                // if a number is found that factors into it, it's not prime
                if (index%i == 0) isPrime = false; 

            if (isPrime) // if this current index number is prime
            {
                System.out.print (index + " "); 
                primeNums.add(index); // add it to the List
            }
        }
    }
}