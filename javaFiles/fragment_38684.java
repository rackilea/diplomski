public static double sumGeom(double term, double ratio, int n)
    {
        double sum = 0;

        if (n<=1)
        {
            return term;
        }
        else
        {
            sum = sum + term * ratio;
            return sumGeom(term * ratio, ratio, n-1);
        }
    }