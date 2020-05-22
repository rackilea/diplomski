public static void main(String[] args) {
    int[] arr = new int[10000000];
    // Warm up
    withModulus(arr);
    withFlag(arr);
    withAnd(arr);
    withTwoLoops(arr);
    // Timing
    int iterations = 100;
    long meanModulus = 0, meanFlag = 0, meanAnd = 0, meanTwoLoops = 0;
    for (int i = 0; i < iterations; i++) {
        meanModulus += withModulus(arr);
    }
    for (int i = 0; i < iterations; i++) {
        meanFlag += withFlag(arr);
    }
    for (int i = 0; i < iterations; i++) {
        meanAnd += withAnd(arr);
    }
    for (int i = 0; i < iterations; i++) {
        meanTwoLoops += withTwoLoops(arr);
    }
    System.out.println("Modulus: "+(meanModulus/iterations)+" ms");
    System.out.println("Flag: "+(meanFlag/iterations)+" ms");
    System.out.println("And: "+(meanAnd/iterations)+" ms");
    System.out.println("Two loops: "+(meanTwoLoops/iterations)+" ms");
}