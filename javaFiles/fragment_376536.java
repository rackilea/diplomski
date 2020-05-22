static double[] minMaxAvg(double[] values) {
    double min = values[0];
    double max = values[0];
    double sum = 0;

    for (double value : values) {
        min = Math.min(value, min);
        max = Math.max(value, max);
        sum += value;
    }

    double avg = sum / values.length;

    return new double[] {min, max, avg};
}

public static void main(String[] args) {
    double[] values = {2,3,4,5,6,7};
    double[] info = minMaxAvg(values);
    System.out.println("Min: " + info[0]);
    System.out.println("Max: " + info[1]);
    System.out.println("Avg: " + info[2]);
}