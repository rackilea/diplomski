public class LineFunction {

    private final double m, b;

    public LineFunction(Line l) {
        /**
         * y= ((y_b-y_a)/(x_b-x_a))*(x-x_a) + y_a
         * 
         * ((y_b-y_a)/(x_b-x_a))==> m
         * 
         * y = m *(x-x_a)+y_a
         * 
         * y= m*x -m*x_a +y_a
         * 
         * -m*x_a +y_a -> b
         * 
         * y = m*x + b
         */
        double y_a, y_b, x_a, x_b;
        x_a = l.getP1().getX();
        y_a = l.getP1().getY();
        x_b = l.getP2().getX();
        y_b = l.getP2().getY();
        m = (y_b - y_a) / (x_b - x_a);
        b = -m * x_a + y_a;

    }

    private LineFunction(double m, double b) {
        this.m = m;
        this.b = b;
    }

    public double computeFor(double xValue) {
        return this.m * xValue + this.b;
    }

    public LineFunction sum(LineFunction other) {
        return new LineFunction(this.m + other.m, this.b + other.b);
    }

    @Override
    public String toString() {
        return "y = " + m + "x + " + b;
    }
}