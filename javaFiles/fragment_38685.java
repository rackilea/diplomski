public static double sumGeom(double term, double ratio, int n)
{
    double sum = 0;

    if (n<=1)
    {
        return term;
    }
    else
    {
        return sum = sum + sumGeom(term * ratio, ratio, n-1);

    }
}