private int Factorial(int num)
{
    if (num <= 1) 
        return 1;
    return num * Factorial(num - 1);
}