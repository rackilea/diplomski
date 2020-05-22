boolean IsSumOfConsecutiveInts(int num)
{
    int sumOfFirstIIntegers = 3;
    for (int i = 2; sumOfFirstIIntegers <= num; i++)
    {
        if (i%2 == 0 ? (num%i == i/2) : (num%i == 0))
        {
            return true;
        }
        sumOfFirstIIntegers += i + 1;
    }
    return false;
}