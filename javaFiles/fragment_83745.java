public static double[] averages(double[]... input) {

    double[] result = new double[input.length];

    for(int i = 0; i< result.length; i++) {
        result[i] = Arrays.stream(input[i]).average().getAsDouble();
    }

    return result;
}