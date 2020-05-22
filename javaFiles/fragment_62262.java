public static void main (String[] args) {
    double[][] alpha = new double[10][5];

    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 5; j++) {
            int index = (5 * i + j);
            if (index < 25) {
                alpha[i][j] = (index * index);
                System.out.println("index(" + index + ")^2 =" + alpha[i][j]);
            } else {
                alpha[i][j] = (3 * index);
                System.out.println("3*index(" + index + ") = " + alpha[i][j]);
            }
        }
    }
}