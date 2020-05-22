for(int j=p;j<=r-1;j++)
{
    if(A[j]<=x)
    {
        i++;
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }
 }