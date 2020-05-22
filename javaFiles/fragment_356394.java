public static double Algorithm()
{
    int m = 1;
    double Pi = 0.0;
    while (countDigits(Pi) < 6) {
        Pi += 4*(Math.pow(-1, m-1)/((2*m)-1)); // I'm assuming this formula works
        m++;
    }
    return Pi;
}