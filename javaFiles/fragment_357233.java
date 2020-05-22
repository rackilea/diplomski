public static double[] multiply(double[] v, double c) {
    double[] newArray = new double[v.length];
    for (int i = 0; i < v.length; i++) {
        newArray[i] = v[i] * c;
    }
    return newArray;
}