public static <T extends Number> T[] mergeSortedArrays (T[] A, T[] B)
{

    int x = 0;
    int y = 0;
    int z = 0;

    T[] C = new T [A.length + B.length];

    for (z = 0 ; x < A.length && y < B.length ; z++)
    {
        if (A[x] < B[y])
            C[z++] = A[x++];
        else
            C[z++] = B[y++];
    }

    while (x < A.length)
        C[z++] = A[x++];

    while (y < B.length)
        C[z++] = B[y++];

    return C;

}