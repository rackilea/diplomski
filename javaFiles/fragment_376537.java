class ValueSummary {
    final double min;
    final double max;
    final double avg;

    static ValueSummary createFor(double[] values) {
        double min = values[0];
        double max = values[0];
        double sum = 0;

        for (double value : values) {
            min = Math.min(value, min);
            max = Math.max(value, max);
            sum += value;
        }

        double avg = sum / values.length;

        return new ValueSummary(min, max, avg);
    }

    ValueSummary(double min, double max, double avg) {
        this.min = min;
        this.max = max;
        this.avg = avg;
    }

    public String toString() {
        return "Min: " + min + "\nMax: " + max +"\nAvg: " + avg;
    }
}


public static void main(String[] args) {
    double[] values = {2,3,4,5,6,7};
    ValueSummary info = ValueSummary.createFor(values);
    System.out.println(info);
}