double[] get1DArray(double[][] twoDarray) {
    double[] tempArray = new double[twoDarray.length * twoDarray[0].length];
    int jdim = twoDarray[0].length;
    for (int i = 0; i < twoDarray.length; i++) {
        System.arraycopy(twoDarray[i], 0, tempArray, i * jdim, jdim);
    }
    return tempArray;
}