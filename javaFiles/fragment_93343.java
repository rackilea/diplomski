if(at[j]<at[j-1])
{
    temp = at[j];
    at[j] = at[j-1];
    at[j-1] = temp;

    temp1 = ft[j]; // <-- here, and ft[j].
    ft[j] = ft[j - 1];
    ft[j] = temp1;
}