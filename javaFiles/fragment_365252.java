import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {


    public static BigInteger func(int n,BigInteger t1, BigInteger t2){
    BigInteger arr[] = new BigInteger[n+1];
    arr[1]=t1;
    arr[2]=t2;
    return func(arr,n);    

    }
    public static BigInteger func(BigInteger[] arr, int n){
        if(n==0||n==1||n==2){
            return arr[n];
        }
        if(arr[n]!=null){
            return arr[n];
        }
        arr[n]=(func(arr,n-1).pow(2)).add(func(arr,n-2));
        return arr[n];
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        BigInteger t1= s.nextBigInteger();       
        BigInteger t2= s.nextBigInteger();       
        int n=s.nextInt();
        System.out.print(func(n,t1,t2));
    }
}