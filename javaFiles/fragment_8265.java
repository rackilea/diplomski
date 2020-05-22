public static int[][] alternative(int[] input) {
    int n = input.length;
    int[][] res = new int[2][n];

    int[] input0 = Arrays.copyOf(input, n);

    Arrays.sort(input0);

    System.out.println("Input: "+Arrays.toString(input)+", ordered: "+Arrays.toString(input0));

    int sum1 = 0, sum2 = 0;
    int a = 0, b = 0;

    for (int i = n-1; i >= 0; i--) {
        if (sum1 <= sum2) {
            res[0][a++] = input0[i];
            sum1 = sum1 + input0[i];
            System.out.println("Adding "+input0[i]+" into set 1 ==> Sum1 = "+sum1);
        } else {
            res[1][b++] = input0[i];
            sum2 = sum2 + input0[i];
            System.out.println("Adding "+input0[i]+" into set 2 ==> Sum2 = "+sum2);
        }
    }
    return res;
}