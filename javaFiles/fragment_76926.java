public static void createMatrix() {

    Random seedBool = new Random(rSeed);

    this.matrix = new boolean[r][c];

    for (int i = 0; i < this.matrix.length; i++) {
        for (int j = 0; j < this.matrix[i].length; j++) {
            this.matrix[i][j] = false;
        }
    }

    for (int i = 1; i < this.matrix.length - 1; i++) {
        for (int j = 1; j < this.matrix[i].length - 1; j++) {
            this.matrix[i][j] = seedBool.nextBoolean();
        }
    }

}