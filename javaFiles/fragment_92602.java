private static List<Double> splitIntoApproxEqualParts(double number, int numParts) {
    if (numParts <= 0) {
        return Collections.emptyList();
    } else if (numParts == 1) {
        return Arrays.asList(number);
    }
    List<Double> result = new ArrayList<>(numParts);
    double qty = Math.floor(number / numParts);
    int t = numParts - 1;
    IntStream.range(0, t).forEach(x -> result.add(qty));
    result.add(number - (qty * t));
    return result;
}