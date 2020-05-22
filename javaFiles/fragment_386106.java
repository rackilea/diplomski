import java.util.Arrays;
import java.util.List;
import org.waltonrobotics.controller.PathData;
import org.waltonrobotics.controller.Pose;

/**
 * Everything about Bezier Curves https://pomax.github.io/bezierinfo/
 */
public class DynamicBezierCurve extends Path {

    private final double startVelocity;
    private final double endVelocity;
    private final int degree;
    private double[] coefficients;

    /**
     * This constructor is used with the splines, but feel free to use it when creating your own motions
     *
     * @param vCruise - the cruise velocity of the robot
     * @param aMax - the maximum acceleration of the robot
     * @param startVelocity - the start velocity
     * @param endVelocity - the end velocity
     * @param isBackwards - whether or not to move the robot backwards
     * @param controlPoints - the control points that define the curve
     */
    public DynamicBezierCurve(double vCruise, double aMax, double startVelocity, double endVelocity,
        boolean isBackwards, List<Pose> controlPoints) {
        super(vCruise, aMax, isBackwards, controlPoints);
        this.startVelocity = startVelocity;
        this.endVelocity = endVelocity;
        // The starting average encoder distance should always be 0

        degree = getKeyPoints().size() - 1;
        coefficients = calculateCoefficients(degree);
    }

    public DynamicBezierCurve(double vCruise, double aMax, double startVelocity, double endVelocity,
        boolean isBackwards,
        Pose... controlPoints) {
        this(vCruise, aMax, startVelocity, endVelocity, isBackwards, Arrays.asList(controlPoints));
    }

    /**
     * Uses the formula to find the value of nCr
     *
     * @return nCr
     */
    private static double findNumberOfCombination(int n, int r) {
        int nFactorial = factorial(n);
        int rFactorial = factorial(r);
        int nMinusRFactorial = factorial(n - r);

        return nFactorial / (rFactorial * nMinusRFactorial);
    }

    /**
     * Finds the factorial of any integer or double, d
     *
     * @return the factorial of d
     */
    private static int factorial(int d) {
        int result = 1;

        for (int i = 1; i <= d; i++) {
            result = result * i;
        }

        return result;
    }


    public double computeArcLength() {

        int n = 100;

        GaussLegendre gl = new GaussLegendre(n, -1, 1);

        double[] t = gl.getNodes();
        double[] C = gl.getWeights();
        double z = 1;

        double sum = 0;

        double zDivision = z / 2;

        for (int i = 0; i < t.length; i++) {
            double ti = t[i];
            ti = zDivision * ti + zDivision;

            Pose point = getDerivative(ti);

            double Ci = C[i];

            sum += Ci * Math.hypot(point.getX(), point.getY());
        }

        sum = zDivision * sum;

        return sum;
    }

    @Override
    public PathData createPathData(double startAverageEncoderLength, PathData previousPathData, double percentage) {
        Pose centerPoint = getPoint(percentage);

        PathData pathData;
//      pathData= calculateData(startAverageEncoderLength, previousPathData, centerPoint);
        pathData = new PathData(centerPoint);
        return pathData;
    }


    private Pose getDerivative(double percentage) {
        double dx = 0;
        double dy = 0;

        if (percentage == 1.0) {

            int last = getKeyPoints().size() - 1;

            dx = getKeyPoints().get(last).getX()
                - getKeyPoints().get(last - 1).getX();
            dy = getKeyPoints().get(last).getY()
                - getKeyPoints().get(last - 1).getY();
        } else {

            double[] coefficients = calculateCoefficients(degree - 1);

            for (int i = 0; i < degree; i++) {

                Pose pointI = getKeyPoints().get(i);

                double multiplier =
                    coefficients[i] * StrictMath.pow(1 - percentage, ((degree - 1) - i)) * StrictMath
                        .pow(percentage, (double) i);

                Pose nextPointI = getKeyPoints().get(i + 1);

                dx += (multiplier = multiplier * (degree)) * (nextPointI.getX() - pointI.getX());
                dy += multiplier * (nextPointI.getY() - pointI.getY());
            }
        }

        double angle = StrictMath.atan2(dy, dx);

        if (isBackwards()) {
            angle += Math.PI;
        }
        angle %= (2 * Math.PI);

        return new Pose(dx, dy, angle);
    }

    private Pose getPoint(double percentage) {
        return getPoint(degree, percentage);
    }

    /**
     * @param percentage - t
     * @return the Pose that is at percentage t along the curve
     */
    private Pose getPoint(double degree, double percentage) {
        double xCoordinateAtPercentage = 0;
        double yCoordinateAtPercentage = 0;

        double dx = 0;
        double dy = 0;

        for (int i = 0; i <= degree; i++) {

            Pose pointI = getKeyPoints().get(i);

            double multiplier =
                coefficients[i] * StrictMath.pow(1 - percentage, (degree - i)) * StrictMath.pow(percentage, (double) i);

            xCoordinateAtPercentage += (multiplier * pointI.getX());
            yCoordinateAtPercentage += (multiplier * pointI.getY());

            if (percentage != 1 && i < degree) {
                Pose nextPointI = getKeyPoints().get(i + 1);

                dx += (multiplier = multiplier * (degree)) * (nextPointI.getX() - pointI.getX());
                dy += multiplier * (nextPointI.getY() - pointI.getY());
            }
        }

        if (percentage == 1.0) {
            int last = getKeyPoints().size() - 1;

            dx = getKeyPoints().get(last).getX()
                - getKeyPoints().get(last - 1).getX();
            dy = getKeyPoints().get(last).getY()
                - getKeyPoints().get(last - 1).getY();
        }

        double angle = StrictMath.atan2(dy, dx);

        if (isBackwards()) {
            angle += Math.PI;
        }
        angle %= (2 * Math.PI);

        return new Pose(xCoordinateAtPercentage, yCoordinateAtPercentage, angle);
//      return new Pose(dx, dy, angle);
    }


    /**
     * Updates the coefficients used for calculations
     */
    private double[] calculateCoefficients(int degree) {
        double[] coefficients = new double[degree + 1];
        for (int i = 0; i < coefficients.length; i++) {
            coefficients[i] = findNumberOfCombination(degree, i);
        }

        return coefficients;
    }
}