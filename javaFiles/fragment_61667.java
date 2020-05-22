List<Function<Number, ? extends Number>> operations = Arrays.asList(
        num ->  num.intValue() + 1,
        num -> num.intValue() - 1,
        num -> num.doubleValue() * 3.14
        ); // just an example list here 

public double getResult() {
    double result = 0.0;

    for (int i = 0; i < operations.size(); i++) {
        if (i == 0) {
            result = operations.get(i).apply(initialValue).doubleValue();
        } else {
            result += operations.get(i).apply(result).doubleValue();
        }
    }
    return result;
}