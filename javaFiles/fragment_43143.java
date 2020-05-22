public static boolean isPrime_helper(int number, int divisor)
{
    /* write code to return true if divisor is > square root of number */
    /* which can also be expressed divisor squared is > number */

    /* write code here to test if divisor divides number without remainder */
    /* and return false if it does.  Otherwise: */

    return isPrime_helper(number, divisor + 2);
}

public static boolean isPrime(int number)
{
    /* deal with the special cases 2, < 2, and even numbers here */
    /* Otherwise: */

    return isPrime_helper(number, 3);
}