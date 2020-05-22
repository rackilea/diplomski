public static double[] arrayProducts(int[] input) {
    int length = input.length;
    double product = 1;
    boolean zeroFound = false;
    int zeroIndex = 0;
    double[] output = null;
    for (int i = 0; i < length; i++) {
        if (input[i] == 0) {
            if (zeroFound) {
                throw new ProductArrayException(0, true, zeroIndex,
                        ZERO_FOUND_EXPECTION);
            }
            zeroFound = true;
            zeroIndex = i;
        } else {
            product = product * input[i];
            if (Double.isInfinite(product)) {
                throw new ProductArrayException(0, true, zeroIndex,
                        INFINITY_FOUND_EXPECTION);
            }
        }
    }

    if (zeroFound) {
        throw new ProductArrayException(product, false, zeroIndex,
                ZERO_FOUND_EXPECTION);
    } else {
        output = new double[length];
        for (int i = 0; i < length; i++) {
            output[i] = product / input[i];
        }
    }
    return output;
}