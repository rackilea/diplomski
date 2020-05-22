interface Term {
    double getValue();
}

class Constant implements Term {
    private double value;
    public double getValue() {
        return value;
    }
}

class Divide implements Term {
    private Term numerator;
    private Term denominator;
    public double getValue() {
        return numerator.getValue() / denominator.getValue();
    }
}