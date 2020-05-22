int last_word_bits(int *bits,int n)
    {
    int i=0;
    if (n<1) return 0;                      // empty
    if (n>=1) i|=bits[n-1];
    if (n>=2) i|=bits[n-2]<<1;
    if (i==1) return 0;                     // ...00 or ...0 -> error
    if (i==0) return 1;                     // ...01 -> 1
    if (i==3) return 2;                     // ...11 -> 2 or error
    // count consequent ones
    for (i=0,n-=2;n>=0;n--,i++)
     if (bits[n]==0) break;
    return 1+(i&1);
    }