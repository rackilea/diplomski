public static double sumGeom(double term, double ratio, int n)
    {
        if (n<=1)
        {
            return term;
        }
        else
        {
            term = term + sumGeom(term * ratio, ratio, n-1);

            return term;
        }
    }