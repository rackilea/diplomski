public static void computeCost (double items[][], double cost[]) {
    for (int row = 0; row < items.length; row++) {
        double rowSum = 0.0;
        for(int col = 0; col < items[row].length; col++) {
            double colProduct = productArray[row] = items[row][col] * cost[col];
            rowSum += colProduct;
            System.out.println("Row: " + row + ", Col: " + col + ": " + colProduct);
        }

        System.out.println("Total row " + row + ": " + rowSum);
    }
}