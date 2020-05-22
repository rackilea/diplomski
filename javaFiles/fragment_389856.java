import static java.lang.Math.*;

public class jdMethods
{

    private double _jd;
    public double getJD(){
        return _jd;
    }

    public void setJD(double y, double m, double d){
        if (m<=2.0){
            y--;
            m += 12.0;
        }
        double a=floor(y/100.0);
        _jd = (365.25*(y+4716.0))+(30.6001*(m+1))+d+(2.0-a+floor(a/4.0))-1524.5;
    }

    public double getToD(int h, int m, int s)
    {
        double a = getJD() + ((h-12)/24) + (m/1440) + (s/86400);
        return a;
    }
}