public int[][] calculate(int[][] first, int[][] second, Operation operation) {
    if(firstArray == null || secondArray == null || firstArray.length != secondArray.length || firstArray.length < 1 || firstArray[0].length != secondArray.length)
        throw new IllegalArgumentException("Arrays can't be null and must be of equal length.");

    int height = firstArray.length;
    int width = firstArray[0].length;
    int[][] result = new int[height][width];
    for(int y = 0; y < height; y++){
        for(int x = 0; x < width; x++){
            result[y][x] = operation.performOn(firstArray[y][x], secondArray[y][x]);
        }
    }
}