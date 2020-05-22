public static int[] youMakeMeOdd(int[] arr) {
    int count = 0;
    for (int n : arr)
        if (n % 2 == 1)
            count++;

    int[] result = new int[count];

    int i = 0;
    for (int n : arr)
        if (n % 2 == 1)
            result[i++] = n;

    return result;
}