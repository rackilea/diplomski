public static int sumOfOddLessThan(int n)
{
    int iResult = 0;
    for(int i = n - 1; i > 0; i--)
    {
        if(i % 2 != 0) {
            iResult = iResult + i;
        }
    }
    return iResult;
}