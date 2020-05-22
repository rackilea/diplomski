static long FindLcm(long a,long b)
{
    long lcm,hcf = 0;
    long i=1;
    // This sets ger to max(a,b) - why?
    long ger=a>b?a:b;
    // This would return a wrong result if a == b
    // that never happens here, though
    while(i<ger)
    {
        if((a%i==0) && (b%i==0))
            hcf=i;
        i++;
    }
    lcm=(a*b)/hcf;
    return lcm;
}