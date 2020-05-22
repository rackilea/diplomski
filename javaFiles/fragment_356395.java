public static double Algorithm(int m,double Pi)
{
    Pi += 4*(Math.pow(-1, m-1)/((2*m)-1));
    if (countDigits(Pi) < 6)
        Pi += Algorithm(m+1,Pi);

    return Pi;
}