int i,j,k;

i=0;
while (i<n) // nXm matrix
{
    k=0;
    j=i+1;
    while (j<m && k<n)
    {
        System.out.print(arr[k][j] + " ");
        j++;
        k++;
    }

    i++;
}