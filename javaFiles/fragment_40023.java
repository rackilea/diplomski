private static boolean CheckSingleSwap(int[] A, int[] B)
{
    int L = A.length;
    int firstSwap = -1, secondSwap = -1;
    for(int i = 0; i < L; i++)
    {
        if(A[i] != B[i])
        {
            if (firstSwap == -1)
                firstSwap = i;
            else if (secondSwap == -1 && A[i] == B[firstSwap] && A[firstSwap] == B[i])
                secondSwap = i;
            else
                return false;
        }
    }
    if (firstSwap != -1 && secondSwap != -1)
    {
        System.out.println("yes");
        System.out.println("swap " + (firstSwap + 1) + " " + (secondSwap + 1));
        return true;
    }
    System.out.println("array is already sorted!");
    return false; // or whatever you decide to do; maybe even an exception or enumerated type
}