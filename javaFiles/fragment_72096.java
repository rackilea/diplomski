public static void main(String args[]) {
    double x[][] = { 
        { 3.24, -0.96 },
        { -1.56, -0.61 },
        { -1.1, 2.5 },
        { 1.36, -4.8 } 
    };

    double[] wA = { 0, 1.94, 3.82 };
    double[] wB = { 0, -4.9, -4.03 };
    double[] wC = { 0, 4.48, 3.25 };

    double threshold = 1;

    int n = x.length;
    for (int i = 0; i < n; i++) {
        System.out.println("For training data point no." + (i + 1));

        double total_A = (threshold * wA[0]) + (x[i][0] * wA[1]) + (x[i][1] * wA[2]);
        double total_B = (threshold * wB[0]) + (x[i][0] * wB[1]) + (x[i][1] * wB[2]);
        double total_C = (threshold * wC[0]) + (x[i][0] * wC[1]) + (x[i][1] * wC[2]);

        double max = Math.max(total_A, Math.max(total_B, total_C));

        System.out.println(total_A + ", " + total_B + ", " + total_C);
        System.out.println("Max is " + max);
    }
}