private static int minimumTotal(List<List<Integer>> triangle, int rowIndex, int colIndex) { 
    if (rowIndex >= triangle.size()) { 
        return 0; 
    } 

    List<Integer> row = triangle.get(rowIndex); 

    int sum1 = row.get(colIndex) + minimumTotal(triangle, rowIndex + 1, colIndex);
    int sum2 = row.get(colIndex) + minimumTotal(triangle, rowIndex + 1, colIndex + 1);
    return Math.min(sum1, sum2); 
}