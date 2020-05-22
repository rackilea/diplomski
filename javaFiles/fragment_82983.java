private static double GetDistance(double x1, double y1, double x2, double y2) 
{
    double a = Math.abs(x1-x2);
    double b = Math.abs(y1-y2);

    return Math.sqrt(a * a + b * b);
}