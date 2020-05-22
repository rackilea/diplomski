public static BigInteger toTimes (BigInteger num)
{
    // Should check for negative input here

    BigInteger product = num;

    // while num is greater than 1
    while (num.compareTo(BigInteger.valueOf(1)) == 1)
    {
        BigInteger minusOne = num.subtract(BigInteger.valueOf(1));
        product = product.multiply(minusOne);

        num = minusOne; // num--;
    }
    return product;
}