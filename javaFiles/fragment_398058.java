public static double[] Difference(double ardY[]) {
    double ardDifference[] = new double[ardY.length - 1];

    boolean allEqual = true;
    double prev;
    for (int j = 0; j < ardDifference.length; j++) {
        ardDifference[j] = ardY[j + 1] - ardY[j];
        if (j != 0) {
            allEqual &= prev == ardDifference[j];
        }
        prev = ardDifference[j];
    }

    if (allEqual) {
        return ardDifference;
    } else {
        return Difference(ardDifference);
    }
}