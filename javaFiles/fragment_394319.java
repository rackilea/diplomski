public static BigInteger toAccumulate (BigInteger num)
{       
    if (num.equals(BigInteger.valueOf(1)))
    {
        return BigInteger.valueOf(1) ;
    }
    else
    {
        // 1+2+...+(n-1)+n = (n)(n+1)/2
        BigInteger addOne = num.add(BigInteger.valueOf(1));
        return num.multiply(addOne).divide(BigInteger.valueOf(2));
    }
}