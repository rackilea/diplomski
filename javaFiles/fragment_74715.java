public class LogLinearFunction2D implements Function2D {
    //Plot ln(ax + b) + c
    double a;
    double b;
    double c;
    public LogLinearFunction2D(double[] params) {
        if(params.length != 3) throw new RuntimeException("Invalid parameters, expected array count 3");
        this.a = params[0];
        this.b = params[1];
        this.c = params[2];
    }
    @Override
    public double getValue(double v) {
        return Math.log(a* v + b) + c;
    }
}