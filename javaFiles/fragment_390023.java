public static void reverse(int[] a)
{
    int l = a.length;
    for (int j = 0; j < l / 2; j++)
    {
        int temp = a[j];
        a[j] = a[l - j - 1];
        a[l - j - 1] = temp;
    }
}