public static int[] powersOfTwoArray(int n) 
{
    int[] result = new int[n+1];  // use "n+1" otherwise it will throw exception
    int i = 0;
    int power = 1;   // initiate power = 1, not power = 0;
    while (i <= n) 
    {
        result[i] = power;
        power *= 2;
        i++;        // increments "i" otherwise its an infinite loop
    }
    return result;
}