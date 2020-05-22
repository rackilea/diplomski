public class AlphaAdjuster {

    private static interface AlphaCalculator {
        double calculate(double alpha0, int t, int rlen, double c);
    }

    public static final int LIN_ALPHA = 1;
    public static final int INV_ALPHA = 2;
    private static final AlphaCalculator LIN_ALPHA_CALCULATOR = new AlphaCalculator(){
        @Override
        public double calculate(double alpha0, int t, int rlen, double c) {
            return alpha0 * (1.0 - (double) t / rlen);
        }};
    private static final AlphaCalculator INV_ALPHA_CALCULATOR = new AlphaCalculator(){
        @Override
        public double calculate(double alpha0, int t, int rlen, double c) {
            return alpha0 * c / (c + t);
        }};

    private AlphaCalculator calculator;
    private int xDim;
    private int yDim;

    public AlphaAdjuster(int alphaType, int xDim, int yDim) {
        if (alphaType == LIN_ALPHA) {
            calculator = LIN_ALPHA_CALCULATOR;
        } else {
            calculator = INV_ALPHA_CALCULATOR;
        }
        this.xDim = xDim;
        this.yDim = yDim;
    }

    public double calculate(double alpha0, int t, int rlen, double c) {
        return calculator.calculate(alpha0, t, rlen, c);
    }
}