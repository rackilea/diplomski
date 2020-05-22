private static class ExpLinearFunction2D implements Function2D {
    //Plot a*e^x + b*x + c
    double a;
    double b;
    double c;
    public ExpLinearFunction2D(double[] params) {
        if(params.length != 3) throw new RuntimeException("Invalid parameters, expected array count 3");
        this.a = params[0];
        this.b = params[1];
        this.c = params[2];
    }
    @Override
    public double getValue(double v) {
        return a * Math.exp(v) + b * v + c;
    }
}