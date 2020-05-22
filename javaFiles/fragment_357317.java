//Constants
/**The maximum number of times the Mandelbrot calculations will be run on a specific point. If the real and imaginary pieces
 * from each calculation don't exceed 2 within the maximum number of iterations, they are part of the Mandelbrot set.
 */
public static final int MAX_ITERATIONS = 30; //The maximum number of times the calculations will be run on a specific point.
private final double MIN_X = -2.0; //The minimum value of x when graphing the Mandelbrot set
private final double MAX_Y = 2.0; //The maximum value of y when graphing the Mandelbrot set
private final double MANDEL_X_RANGE = 4.0; //The range of x values from -2 to 2 when graphing the Mandelbrot set
private final double MANDEL_Y_RANGE = 4.0; //The range of y values from -2 to 2 when graphing the Mandelbrot set

//Instance Fields
private ComplexNum z; //In the Mandelbrot equation of Z_(n+1)=Z_n^2+C, this is the value of Z_n^2
private ComplexNum c; //In the Mandelbrot equation of Z_(n+1)=Z_n^2+C, this is the value of C
private ComplexNum currentCalc; //In the Mandelbrot equation of Z_(n+1)=Z_n^2+C, this is the value of Z_(n+1)
private int numIterations; //The current number of iterations

//Constructor
/**Create a MandelbrotGenerator object.
 */
public MandelbrotGenerator(){
    z = new ComplexNum(0,0);
    c = new ComplexNum(0,0);
    currentCalc = new ComplexNum(0,0);
    numIterations = 0;
}

//Methods
/**Carry out the Mandelbrot calculation on the point at the (x,y) coordinates specified by the parameters. The return value specifies
 * whether or not this point is within the Mandelbrot set, which is determined by whether or not the values of the real and imaginary
 * pieces of currentCalc, or Z_(n+1) from the Mandelbrot equation, both reach or exceed the value of 2 within a number of iterations
 * less than or equal to MAX_ITERATIONS.
 * (Postcondition: the program will return an int value which can be used to determine whether the input point is within the Mandelbrot set)
 * @param xVal -- the double value of the desired x coordinate
 * (Precondition: xVal is a real number)
 * @param yVal -- the double value of the desired y coordinate
 * (Precondition: yVal is a real number)
 * @return returns the number of iterations needed to meet or exceed the 2 threshold, or the value of MAX_ITERATIONS if the threshold is never met
 */
public int calculateMandelbrot(double xVal, double yVal, double panelWidth, double panelHeight){
    double xCord = convertToMandelX(xVal, panelWidth);
    double yCord = convertToMandelY(yVal, panelHeight);
    c = new ComplexNum(xCord,-yCord);
    z = new ComplexNum(0,0);
    currentCalc = new ComplexNum(0,0);
    numIterations=0;
    while(numIterations<=MAX_ITERATIONS && Math.pow(currentCalc.getRealPart(),2)+Math.pow(currentCalc.getImgPart(),2)<=4.0){
        numIterations++;
        z = currentCalc;
        currentCalc = z.squareComplex();
        currentCalc = currentCalc.add(c);
    }
    return numIterations;
}

public double convertToMandelX(double xPixLoc, double maxXVal){
    double xCoordinate = MIN_X + ((xPixLoc/maxXVal)*MANDEL_X_RANGE);
    return xCoordinate;
}

public double convertToMandelY(double yPixLoc, double maxYVal){
    double yCoordinate = MAX_Y -((yPixLoc/maxYVal)*MANDEL_Y_RANGE);
    return yCoordinate;
}