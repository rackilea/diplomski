for (DoubleTwoDArrayWritable value : values) {
    Writable[][] currentArray = value.get();
    int rowSize = currentArray.length;
    int columnSize = currentArray[0].length;
    double[][] myArray = new double[rowSize][columnSize];

    for (int i = 0; i < currentArray.length; i++) {
        for (int j = 0; j < currentArray[i].length; j++) {
             myArray[i][j] = ((DoubleWritable)currentArray[i][j]).get();
        }
    }
}