private static boolean CheckSingleReverse(int[] A, int[] B)
{
    // find region
    int L = A.length;
    int diffStart = -1, diffEnd = -1; boolean mid = false, found = false;
    for (int i = 0; i < L; i++)
    {
        if (A[i] != B[i])
        {
            if (found)
            {
                if (i - diffEnd == 2 && !mid)
                {
                    mid = true;
                    found = false;
                    diffEnd = -1;
                }
                else
                    return false;
            }
            else if (diffStart == -1)
                diffStart = i;
        }
        else 
        if (diffStart != -1 && diffEnd == -1)
        {
            found = true;
            diffEnd = i - 1;
        }
    }
    if (diffEnd == -1)
    {
        if (A[L - 1] != B[L - 1])
            diffEnd = L - 1;
        else if (!found)
        {
            System.out.println("array is already sorted!");
            return false;
        }
    }

    // find out if it's reversed
    int count = (diffEnd - diffStart + 1) / 2;
    for (int i = 0; i < count; i++)
    {
        int oneEnd = diffStart + i, otherEnd = diffEnd - i;
        if (!(A[oneEnd] == B[otherEnd] && A[otherEnd] == B[oneEnd]))
            return false;
    }
    System.out.println("yes");
    System.out.println("reverse " + (diffStart + 1) + " " + (diffEnd + 1));
    return true;   
}