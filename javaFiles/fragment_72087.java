if(p<r)
{
    int q = partition(A,p,r);
    quickSort(A,p,q-1);
    quickSort(A,q+1,r);
}