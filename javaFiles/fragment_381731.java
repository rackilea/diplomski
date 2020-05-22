public static boolean isDivisibleBy7 (int n)
{       
    n = Math.abs(n);

    if (n == 0 || n == 7 || n == 14)
    {
        return true;
    }
    else
    {
        int lastDigit = n % 10;
        int lastDigitOff = n / 10;

        int remainder = lastDigitOff - (lastDigit * 2);

        remainder = Math.abs(remainder);

        if (remainder > n)
        {
            return false;
        }

        return isDivisibleBy7(remainder);
    }
}