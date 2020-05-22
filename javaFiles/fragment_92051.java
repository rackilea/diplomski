static void compare(int n)
{
    int[] arr = new int[n];
    Random r = new Random();
    while (true)
    {
        for (int i = 0; i < n; i++)
            arr[i] = r.nextInt(10);

        int maxBrute = BruteDiv3.maxDiv3(arr);
        int maxSO = new Main().answer(arr);

        if (maxBrute % 3 != 0)
            System.out.println("Bad Brute: " + maxBrute);
        if (maxSO % 3 != 0)
            System.out.println("Bad SO: " + maxSO);

        if (maxBrute != maxSO)
        {
            System.out.println(Arrays.toString(arr) + " " + maxBrute + " " + maxSO);
        }
    }
}