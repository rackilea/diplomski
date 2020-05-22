public static double calculateAverage(List <Integer> values) {
    double sum = 0d;
    if(!values.isEmpty()) {
        for (Integer value: values) {
            sum += value;
        }
        return sum / values.size();
    }
    return sum;
}