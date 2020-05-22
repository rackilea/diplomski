class AlgosPart2 {
    private double f2c;

    public void f2c(double farenheit) {
        this.f2c = (farenheit - 32) * 5 / 9;
    }

    public double getf2c() {
        return f2c;
    }
}