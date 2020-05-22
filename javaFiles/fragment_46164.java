public static void main(String... args) throws IOException {
    int[][] t1 = new int[2][2];
    t1[0][0] = 0;
    t1[0][1] = 1;
    t1[1][0] = 2;
    t1[1][1] = 3;

    double[][] t2 = new double[2][2];
    t2[0][0] = 3;
    t2[0][1] = 2;
    t2[1][0] = 1;
    t2[1][1] = 0;

    boolean[][] f = new boolean[2][2];

    for (int i = 0; i < 2; i++) {
        for (int j = 0; j < 2; j++) {
            if (t1[i][j] > t2[i][j]) {
                f[i][j] = true;
            } else {
                f[i][j] = false;
            }
            System.out.println(i+" "+j+" :"+f[i][j]);
        }
    }
}