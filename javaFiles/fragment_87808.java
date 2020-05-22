public static int validateWithSingleThread(int n)
{

    int[] numbers = new int[n];

    for(int itt = 0; itt<n; itt++)
    {
        int max = -1;
        for(int i = 0; i<numbers.length; i++)
        {
            if(numbers[i] > max)
            {
                max = numbers[i];
            }
        }

        for(int i = 0; i<numbers.length; i++)
        {
            if(numbers[i] == 0)
            {
                numbers[i] = ++max;
            }
        }       
    }

    int sum = 0;

    for(int number : numbers)
    {
        sum += number;
    }


    return sum;

}