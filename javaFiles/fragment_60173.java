import java.util.Scanner;

public class Test4{

public static void main(String[] args) {
    RiemannZetaMain func = new RiemannZetaMain();
    double s = 0;
    double start, stop, totalTime;
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter the value of s inside the Riemann Zeta Function: ");
    try {
            s = scan.nextDouble();
    } 
    catch (Exception e) {
        System.out.println("You must enter a positive integer greater than 1.");
    }
    start = System.currentTimeMillis();
    if(s >= 2)
        System.out.println("Value for the Zeta Function = " + getStandardSum(s));
    else
        System.out.println("Value for the Zeta Function = " + getRiemannSum(s));
    stop = System.currentTimeMillis();
    totalTime = (double) (stop-start) / 1000.0;
    System.out.println("Total time taken is " + totalTime + " seconds.");
}

// Standard form the the Zeta function.
public static double standardZeta(double s) {
    int n = 1;
    double currentSum = 0;
    double relativeError = 1;
    double error = 0.000001;
    double remainder;

    while (relativeError > error) {
        currentSum = Math.pow(n, -s) + currentSum;
        remainder = 1 / ((s-1)* Math.pow(n, (s-1)));
        relativeError =  remainder / currentSum;
        n++;
    }
    System.out.println("The number of terms summed was " + n + ".");
    return currentSum;
}

public static double getStandardSum(double s){
    return standardZeta(s);
}

// Riemann's Functional Equation
public static double riemannFuncForm(double s, double threshold, double currSteps, int maxSteps) {
double term = Math.pow(2, s)*Math.pow(Math.PI, s-1)*(Math.sin((Math.PI*s)/2))*gamma(1-s);
//double nextTerm = Math.pow(2, (1-s))*Math.pow(Math.PI, (1-s)-1)*(Math.sin((Math.PI*(1-s))/2))*gamma(1-(1-s));
//double error = Math.abs(term - nextTerm);

if(s == 1.0)
    return 0;
else if (s == 0.0)
    return -0.5;
else if (term < threshold) {//The recursion will stop once the term is less than the threshold
    System.out.println("The number of steps is " + currSteps);
    return term;
}
else if (currSteps == maxSteps) {//The recursion will stop if you meet the max steps
    System.out.println("The series did not converge.");
    return term;
}    
else //Otherwise just keep recursing
    return term*riemannFuncForm(1-s, threshold, ++currSteps, maxSteps);
}

public static double getRiemannSum(double s) {
    double threshold = 0.00001;
    double currSteps = 1;
    int maxSteps = 1000;
    return riemannFuncForm(s, threshold, currSteps, maxSteps);
}

// Gamma Function - Lanczos approximation
public static double gamma(double s){
                double[] p = {0.99999999999980993, 676.5203681218851, -1259.1392167224028,
                                  771.32342877765313, -176.61502916214059, 12.507343278686905,
                                  -0.13857109526572012, 9.9843695780195716e-6, 1.5056327351493116e-7};
                int g = 7;
                if(s < 0.5) return Math.PI / (Math.sin(Math.PI * s)*gamma(1-s));

                s -= 1;
                double a = p[0];
                double t = s+g+0.5;
                for(int i = 1; i < p.length; i++){
                        a += p[i]/(s+i);
                }

                return Math.sqrt(2*Math.PI)*Math.pow(t, s+0.5)*Math.exp(-t)*a;
        }

//Binomial Co-efficient
public static double binomial(int n, int k)
{
    if (k>n-k)
        k=n-k;

    long b=1;
    for (int i=1, m=n; i<=k; i++, m--)
        b=b*m/i;
    return b;
}