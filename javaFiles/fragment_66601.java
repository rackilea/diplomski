public static Array merge(Array A, Array B)
{
    Array C = new Array(A.a.length + B.a.length);
    int i = 0, j = 0, k = 0;

    while(i < A.a.length && j < B.a.length)
    {
        if(A.a[i] < B.a[j])
            C.a[k++] = A.a[i++];
        else if(A.a[i] > B.a[j])
            C.a[k++] = B.a[j++];
        else
        {
            C.a[k++] = A.a[i++];
            C.a[k++] = B.a[j++]; // this preserves duplicates
        }
    }

    while(i < A.a.length)
        C.a[k++] = A.a[i++];

    while(j < B.a.length)
        C.a[k++] = B.a[j++];

    return C;
}