static int[] findMinMaxRecDesc(int[] A, int n) {
    if (n == 0) {
        return new int[]{A[0], A[0]};
    }
    int[] recResult = findMinMaxRecDesc(A, n - 1);
    return new int[]{Math.min(A[n - 1], recResult[0]), Math.max(A[n - 1], recResult[1])};
}

static int[] findMinMaxRecAsc(int[] A, int n) {
    if (n == A.length - 1) {
        return new int[]{A[n], A[n]};
    }
    int[] recResult = findMinMaxRecAsc(A, n + 1);
    return new int[]{Math.min(A[n], recResult[0]), Math.max(A[n], recResult[1])};
}


public static void main(String[] args) {
    int[] array = {1, 4, 45, 6, -50, 10, 2};
    int[] result = Arrays.toString(findMinMaxRecAsc(array, array.length))
    System.out.println(result); // [-50, 45]
}