static int p(int n)
   {

    System.out.println(n);
    int newN = n;
    if (n > 0)
    {
        newN = n*p(n-1);
    }
    System.out.println(newN);
    return newN==0?1:newN;
}