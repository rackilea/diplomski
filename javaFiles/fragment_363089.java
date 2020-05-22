public static void main(String[] args) {
    int x[] = {1, 4, 2, 3, 0, 5};
    System.out.println(pairwise(x, 7));
}

public static int pairwise(int[] arr, int N) {
    int t = 0;
    for (int i = 0; i < arr.length - 1; i++) {
        for (int k = i + 1; k < arr.length; k++) {
            if (arr[i] + arr[k] == N) {
                t += i + k;
                arr[i] = arr[k] = Integer.MIN_VALUE; // don't use these again
                continue;
            }
        }
    }
    return t;
}