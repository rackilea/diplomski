public static double complexSumFunctionA(int[] input) {
    double sum = 0, val;
    for (int i = 0; i < input.length; i++) {
        val = Math.pow(input[i] / 2.0, i / 2.0);
        sum += val;
    }
    return sum / (input.length + 3);
}