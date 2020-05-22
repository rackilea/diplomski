public static double[][] formatArray(double[][] array) {

    double[][] newArray = new double[array.length][array[0].length];
    for(int i = 0; i < array.length; i++){
        for(int y = 0; y < array[0].length; y++){
            newArray[i][y] = (double)Math.round(array[i][y] * 10000) / 10000;
        }
    }
    return newArray;
}