public static void main(String[] args) throws NullPointerException {
    Scanner sc = new Scanner(System.in);
    double[][] inputMatrix = new double[5][5];
    try {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                inputMatrix[i][j] = sc.nextInt();
            }
        }
        Matrixer mx = new Matrixer(5, 5, inputMatrix);
        mx.computeAverages();
        mx.printComputedMatrix();
    } catch (NullPointerException e) {
        e.printStackTrace();
    }
}