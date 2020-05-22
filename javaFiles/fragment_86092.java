public static void main(String[] args)
{
    int[] A = {4,3,9,2,7,6,5};      
    sort(A);        
    System.out.println(Arrays.toString(A));
}

public static void sort(int[] arr)
{
    int split = arr[0];

    int front = 0;
    int back = arr.length-1;
    for(int i=1; front != back; )
    {
        if(arr[i] <= split)
        {
            arr[front] = arr[i];
            front += 1;
            i++;
        }
        else
        {
            swap(arr, i, back);
            back -= 1;
        }
    }
    arr[front] = split;
}

public static void swap(int[] arr, int i, int j)
{
    int t = arr[i];
    arr[i] = arr[j];
    arr[j] = t;
}