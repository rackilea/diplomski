int num; // is the number being tested for if it's prime.
boolean isPrime = true;

for (int i = 2; i <= Math.sqrt(num); i++) // only have to test until the square root of the number
{
    if (num%i == 0) // if the number is divisible by anything from 2 - the square root of the number
    {
        isPrime = false; // it is not prime
        break; // break out of the loop because it's not prime and no more testing needed
    }
}

if (isPrime) 
{
    System.out.println(num + " is a prime number.");
}
else
{
    System.out.println(num + " is a composite number.");
}