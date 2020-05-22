import java.io.PrintWriter;
import org.apfloat.ApcomplexMath;
import org.apfloat.Apcomplex;
import org.apfloat.Apfloat;
import org.apfloat.samples.Pi;

public class ZetaFinder
{
    //Number of sig figs accuracy.  Note that infinite should be reserved
    private static long PRECISION = 40l; 
    // Convergence criterion for integration
    static Apfloat EPSILON = new Apfloat("1e-15",PRECISION);

    //Value of PI - enhanced using Apfloat library sample calculation of Pi in constructor,
    //Fast enough that we don't need to hard code the value in.
    //You could code hard value in for perf enhancement
    static Apfloat PI = null; //new Apfloat("3.14159"); 

    //Integration limits - I found too high a value for "infinity" causes integration
    //to terminate on first iteration.  Plot the integrand to see why...
    static Apfloat INFINITE_LIMIT = new Apfloat("40",PRECISION);
    static Apfloat ZERO_LIMIT = new Apfloat("1e-16",PRECISION); //You can use zero for the 25.5.12

    static Apfloat one = new Apfloat("1",PRECISION);
    static Apfloat two = new Apfloat("2",PRECISION);
    static Apfloat four = new Apfloat("4",PRECISION);
    static Apfloat six = new Apfloat("6",PRECISION);
    static Apfloat twelve = new Apfloat("12",PRECISION);
    static Apfloat fifteen = new Apfloat("15",PRECISION);

    static int counter = 0;

    Apcomplex s = null;

    public ZetaFinder(Apcomplex s)
    {
        this.s = s;
        Pi.setOut(new PrintWriter(System.out, true));
        Pi.setErr(new PrintWriter(System.err, true));
        PI = (new Pi.RamanujanPiCalculator(PRECISION+10, 10)).execute(); //Get Pi to a higher precision than integer consts
        System.out.println("Created a Zeta Finder based on Abel-Plana for s="+s.toString() + " using PI="+PI.toString());
    }

    public static void main(String[] args)
    {
        Apfloat re = new Apfloat("2", PRECISION);
        Apfloat im = new Apfloat("3", PRECISION);
        Apcomplex s = new Apcomplex(re,im);

        ZetaFinder finder = new ZetaFinder(s);

        System.out.println(finder.findZeta());
    }

    private Apcomplex findZeta()
    {
        Apcomplex retval = null;

        //Method currently in question (a.k.a. 25.5.12)
        //Apcomplex mult = ApcomplexMath.pow(two, this.s);
        //Apcomplex firstterm = (ApcomplexMath.pow(two, (this.s.add(one.negate())))).divide(this.s.add(one.negate()));

        //Easier integrand method (a.k.a. 25.5.11)
        Apcomplex mult = two;
        Apcomplex firstterm = (one.divide(two)).add(one.divide(this.s.add(one.negate())));

        Apfloat limita = ZERO_LIMIT;//Apfloat.ZERO;
        Apfloat limitb = INFINITE_LIMIT;
        System.out.println("Trying to integrate between " + limita.toString() + " and " + limitb.toString());
        Apcomplex integral = adaptiveQuad(limita, limitb);
        retval = firstterm.add((mult.multiply(integral)));
        return retval;
    }

    private Apcomplex adaptiveQuad(Apfloat a, Apfloat b) {
        //if (counter % 100 == 0)
        {
            System.out.println("In here for the " + counter + "th time");
        }
        counter++;
        Apfloat h = b.add(a.negate());
        Apfloat c = (a.add(b)).divide(two);
        Apfloat d = (a.add(c)).divide(two);
        Apfloat e = (b.add(c)).divide(two);

        Apcomplex Q1 = (h.divide(six)).multiply(f(a).add(four.multiply(f(c))).add(f(b)));
        Apcomplex Q2 = (h.divide(twelve)).multiply(f(a).add(four.multiply(f(d))).add(two.multiply(f(c))).add(four.multiply(f(e))).add(f(b)));
        if (ApcomplexMath.abs(Q2.add(Q1.negate())).compareTo(EPSILON) < 0)
        {
            System.out.println("Returning");
            return Q2.add((Q2.add(Q1.negate())).divide(fifteen));
        }
        else
        {
            System.out.println("Recursing with intervals "+a+" to " + c + " and " + c + " to " +d);
            return adaptiveQuad(a, c).add(adaptiveQuad(c, b));
        }
    }

    private Apcomplex f(Apfloat x)
    {
        return integrand2(x);
    }

    /*
     * Simple test integrand (z^2)
     * 
     * Can test implementation by asserting that the adaptiveQuad
     * with this function evaluates to z^3 / 3
     */
    private Apcomplex integrandTest(Apfloat t)
    {
        return ApcomplexMath.pow(t, two);
    }

    /*
     * Abel-Plana formulation integrand
     */
    private Apcomplex integrand1(Apfloat t)
    {
        Apcomplex numerator = ApcomplexMath.sin(this.s.multiply(ApcomplexMath.atan(t)));
        Apcomplex bottomlinefirstbr = one.add(ApcomplexMath.pow(t, two));
        Apcomplex D1 = ApcomplexMath.pow(bottomlinefirstbr, this.s.divide(two));
        Apcomplex D2 = (ApcomplexMath.exp(PI.multiply(t))).add(one);    
        Apcomplex denominator = D1.multiply(D2);
        Apcomplex retval = numerator.divide(denominator);       
        //System.out.println("Integrand evaluated at "+t+ " is "+retval);
        return retval;
    }

    /*
     * Abel-Plana formulation integrand 25.5.11 
     */
    private Apcomplex integrand2(Apfloat t)
    {
        Apcomplex numerator = ApcomplexMath.sin(this.s.multiply(ApcomplexMath.atan(t)));
        Apcomplex bottomlinefirstbr = one.add(ApcomplexMath.pow(t, two));
        Apcomplex D1 = ApcomplexMath.pow(bottomlinefirstbr, this.s.divide(two));
        Apcomplex D2 = ApcomplexMath.exp(two.multiply(PI.multiply(t))).add(one.negate());    
        Apcomplex denominator = D1.multiply(D2);
        Apcomplex retval = numerator.divide(denominator);       
        //System.out.println("Integrand evaluated at "+t+ " is "+retval);
        return retval;
    }
}