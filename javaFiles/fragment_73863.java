static int[] method2(int[] A, int[] B, int[] C) {
    Arrays.sort(A);
    int[] result = new int[B.length];
    for (int i = 0; i < B.length; i++) {
        int posMin = java.util.Arrays.binarySearch(A, B[i]);
        int posMax = java.util.Arrays.binarySearch(A, C[i]);
        if (posMin < 0) { posMin = -(posMin+1);   }
        if (posMax < 0) { posMax = -(posMax+1)-1; }
        result[i] = posMax - posMin +1;
    }
    return result;
}