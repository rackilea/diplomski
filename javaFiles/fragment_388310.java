public static double calculateAll(List<Double> allNumbers) {
    double average;
    double total = 0.0;
    for (Double allNumber : allNumbers) {
        total += allNumber;
    }
    average = total / allNumbers.size();
    return average;
}