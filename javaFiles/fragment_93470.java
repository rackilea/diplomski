int num = new Scanner(System.in).nextInt();  

if( number > 50 )
{
    if(isPrime(number))
    {
       // print out is prime
    }
    // print out it is not prime
}

else
{
    System.out.println("Prime numbers from 1 to " + num + " are: ");  

    for(int number = 2; number<=num; number++){  
       if(isPrime(number)){  
            System.out.println(number);  
        }   
    }
 }