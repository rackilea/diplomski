for (int row = 0; row < matrix.length; row++) {
    for (int nodeRow = 0; nodeRow < 3; nodeRow++) {
        for (int col = 0; col < matrix.length; col++) {
            Node cur = matrix[row][col];
            cur.printRow(nodeRow);
            if (col == matrix.length - 1)
                System.out.println();
       }
    }
}