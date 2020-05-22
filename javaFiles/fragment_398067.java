public static void main(String []args){
    int valueA = 1;
    int valueB = 100;
    int count = 0;
    for(int number = valueA; number <= valueB; number++)
    {
        if(isPrime(number))
        {
            count++;
            System.out.println(number);
        }
    }
    System.out.println("count = " + count);
}

public static boolean isPrime(int n)
{
    for(int i = 2; i*i <= n; i++)
    {
        if(n % i == 0)
        {
            return false;
        }
    }
    return n > 1;
}