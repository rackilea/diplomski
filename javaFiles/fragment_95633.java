public static void reverseArray(int arr[], int start, int end)
{
    int len = end - start;
    if(len <= 0) return;

    int len2 = len >> 1;
    int temp;

    for (int i = 0; i < len2; ++i)
    {
        temp = arr[start + i];
        arr[start + i] = arr[end - i - 1];
        arr[end - i - 1] = temp;
    }
}