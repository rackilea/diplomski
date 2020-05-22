import java.util.*;
import java.lang.*;
import java.io.*;

public class AllFactorsArePrime {
    public static void main(String[] args) {
        AllFactorsArePrime obj = new AllFactorsArePrime();
        boolean result = obj.areAllFactorsPrime(32);
        System.out.println(result);
    }

    public boolean areAllFactorsPrime(int n) {
            int count=0;
            int j=0;
            double k=n;
            while(n%2==0){
            n=n/2;
            j=2;
            count++;
            }

            for(int i=3; i<=n;i=i+2){
            while(n%i==0){
            n=n/i;
            j=i;
            count++;
            }
            }

           if(count>=3)
           {
               return false;
           }
           else
               return true;
            }
}