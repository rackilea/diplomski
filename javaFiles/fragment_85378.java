package test;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        long t,n;
        BigInteger sum;
        Scanner in=new Scanner(System.in);
        t=in.nextLong();
        for(int i=0;i<t;i++)
        {
            sum = BigInteger.ZERO;
            n=in.nextLong();
            long l3=0,l5=0,l15=0;
            for(int j=3;j>0;j--)
                if((n-j)%3==0&&j<n)
                {
                    l3=n-j;
                    break;
                }
            for(int j=5;j>0;j--)
                if((n-j)%5==0&&j<n)
                {
                    l5=n-j;
                    break;
                }
            for(int j=15;j>0;j--)
                if((n-j)%15==0&&j<n)
                {
                    l15=n-j;
                    break;
                }

            BigDecimal x = BigDecimal.valueOf(l3)
            .divide(BigDecimal.valueOf(6))
            .multiply(BigDecimal.valueOf(l3+3));
            sum=sum.add(x.toBigIntegerExact());
            x = BigDecimal.valueOf(l5)
            .divide(BigDecimal.valueOf(10))
            .multiply(BigDecimal.valueOf(l5+5));
            sum=sum.add(x.toBigIntegerExact());
            x = BigDecimal.valueOf(l15)
            .divide(BigDecimal.valueOf(30))
            .multiply(BigDecimal.valueOf(l15+15));
            sum=sum.subtract(x.toBigIntegerExact());

            System.out.println(sum);    
        }
    }
}