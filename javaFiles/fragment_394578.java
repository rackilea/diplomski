public static double calProduct(double[]... numberArrays) {
    double total = 0.0;
    int count = 0;

    for (double[] numbers : numberArrays) {
        for (double number : numbers) {
            total += number;
            count++;
        }
    }

    return total / count;
}