public static double Ave(Array_two a) {
    double sum = 0; // you want to return a double
    double total = a.rows * a.cols;
    if (total == 0) return 0; // watch out for possible division by 0
    for (int i = 0; i < a.rows; i++) {
        for (int j = 0; j < a.cols; j++) {
            sum += a.values[i][j];
        }
    }
    return sum / total;
}