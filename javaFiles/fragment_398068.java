public static void main(String []args){
    int valueA = 1;
    int valueB = 100;
    int count = 0;
    for(int number = valueA; number <= valueB; number++)
    {
        boolean isPrime = number > 1;
        for(int i = 2; i*i <= number; i++)
        {
            if(number % i == 0)
            {
                isPrime = false;
                break;
            }
        }
        if(isPrime)
        {
            count++;
            System.out.println(number);
        }
    }
    System.out.println("count = " + count);
}