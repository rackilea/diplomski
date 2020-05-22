int[] a = {1, 2, 1, 1, 2, 2};

int j = a.length-1;
for (int i=0; i<j; i++)
{
    if (a[i] == 2)
    {
        int tmp = a[i];         // swap a[i] and a[j]
        a[i] = a[j];
        a[j] = tmp;

        j--;

        if (a[i] == 2)
            i--;
    }
}