public static void printPrime(int[] arr)
{
    int len = arr.length;
    String sep = "";    // HERE
    for(int i = 0; i < len; i++)
    {
        int c = countFactor(arr[i]);

        if(c == 2)
        {
         System.out.print(sep);  // HERE
         sep = ",";
         System.out.print(arr[i]);
        }

    }
}