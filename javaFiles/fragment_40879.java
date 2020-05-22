public static void main(String[] args) {
    int[] A = {1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1};
    System.out.println(floodOnes(A, 0, A.length - 1, 9));  // prints 5 
    System.out.println(floodOnes(A, 0, A.length - 1, 3));  // prints 0 
    System.out.println(floodOnes(A, 0, A.length - 1, 0));  // prints 3 
    System.out.println(floodOnes(A, 0, A.length - 1, 14)); // prints 2 
}

public static int checkLeft(int[] A, int k) {
    return (k < 0 || A[k] != 1) ? 0 : 1 + checkLeft(A, k - 1);
}

public static int checkRight(int[] A, int k) {
    return (k > (A.length - 1) || A[k] != 1) ? 0 : 1 + checkRight(A, k + 1);
}

public static int floodOnes(int[] A, int left, int right, int k) {
    return (A[k] != 1) ? 0 : checkLeft(A, k - 1) + 1 + checkRight(A, k + 1);
}