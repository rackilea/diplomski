class Test {
    public static void main(String[] args) {
        Try<String> r = ratio(2.0, 3.0).flatMap(Test::asString);
    }

    static Try<Double> ratio(double a, double b) {
        if (b == 0) {
            return new Try.Fail<Double>("Divide by zero");
        } else {
            return new Try.Success<Double>(a / b);
        }
    }

    static Try<String> asString(double d) {
        if (Double.isNaN(d)) {
            return new Try.Fail<String>("NaN");
        } else {
            return new Try.Success<String>(Double.toString(d));
        }
    }
}