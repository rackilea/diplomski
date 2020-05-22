public static int[][] bruteForce(int[] input) {
    int n = input.length;
    int[][] res = new int[2][n];
    int minVal = Integer.MAX_VALUE;
    int iMinVal = 0;
    int limit = (int) Math.pow(2, n);

    for (int i = 0; i < limit; i++) {
        int v = i;
        int diff = 0;
        for (int j = 0; j < n; j++) {
            diff = diff + ((v & 1) == 0 ? +1 : -1) * input[j];
            v = v >> 1;
        }
        if (Math.abs(diff) < minVal) {
            iMinVal = i;
            minVal = Math.abs(diff);
        }
    }

    int a = 0, b = 0;
    for (int i = 0; i < n; i++) {
        if ((iMinVal & 1) == 0) {
            res[0][a++] = input[i];
        } else {
            res[1][b++] = input[i];
        }
        iMinVal = iMinVal >> 1;
    }

    return res;
}

public static void main(String[] args) {
    int[] num = {5 ,8 ,1 ,1 ,2 ,3 ,2};
    int[] num2 = {4, 6, 1, 2, 3, 3, 4};

    int[][] r = bruteForce(num);
    System.out.println("First example:");
    System.out.println(Arrays.toString(r[0])+ ", sum = "+Arrays.stream(r[0]).sum());
    System.out.println(Arrays.toString(r[1])+ ", sum = "+Arrays.stream(r[1]).sum());

    r = bruteForce(num2);
    System.out.println("Second example:");
    System.out.println(Arrays.toString(r[0])+ ", sum = "+Arrays.stream(r[0]).sum());
    System.out.println(Arrays.toString(r[1])+ ", sum = "+Arrays.stream(r[1]).sum());
}