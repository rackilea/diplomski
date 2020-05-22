boolean compareCars(List<Car> cars1, List<Car> cars2) {
    boolean isSingleOccuranceMatch = false;
    for (Car car : cars1) {
        if (cars2.contains(car)) {
            isSingleOccuranceMatch = true;
            break;
        }
    }

    return isSingleOccuranceMatch;
}