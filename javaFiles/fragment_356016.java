private int Factorial(int num)
{
    int result = 1;
    if (num <= 1) 
       return result;
    while (num > 1)
    {
        result * = num;
        num--;
    }
    return result;
}