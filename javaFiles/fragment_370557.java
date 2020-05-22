List<Double> calcRangeEnds(double maxValue) {
    List<Double> result = new ArrayList<Double>();
    double base = 1;
    while(base / 2 <= maxValue) { //the last value added is base / 2
        result.add(base);
        result.add(base * 2);
        result.add(base * 5);
        base *= 10;
    }
    return result;
}