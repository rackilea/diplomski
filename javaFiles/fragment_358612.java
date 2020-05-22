private double calculateSeriesResistance() {
    double runningResistance = 0;
    for (int index = 0; index < resistor.size(); index++) {
        runningResistance += resistor.get(index);
    }
    return runningResistance;
}