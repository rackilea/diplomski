static long fact(long n)
{
   if(n==1)
       return 1;
    long result =  n*fact(n-1);
    System.out.println(n + ", " + result);
    return result;
}