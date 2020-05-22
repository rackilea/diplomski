import java.math.BigInteger;
public static BigInteger fib(int n)
{
    return fib2h(n,BigInteger.ONE,BigInteger.ONE);
}


public static BigInteger fibh(int n,BigInteger o,BigInteger p)
{
    if(n==1) return o;
    return fib2h(n-1,p,o.add(p));
}