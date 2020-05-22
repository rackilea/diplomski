public int PermSolution(int[] A)
{

int perm = 1;
Arrays.sort(A);

if (A[0] != 1) return 0;

for (int i = 0; i < A.length; i++)
{
       if (A[i] + 1 != A[i + 1])
    {
        return 0;
    }
}

return perm;

}