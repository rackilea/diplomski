import static java.lang.Math.*;

public class Utility
{
    public static double getJD(double y,double m,double d){
        if (m<=2.0) {
            y--;
            m+=12.0;
        }
        double a=floor(y/100.0);
        return (365.25*(y+4716.0))+(30.6001*(m+1))+d+(2.0-a+floor(a/4.0))-1524.5;
    }
}