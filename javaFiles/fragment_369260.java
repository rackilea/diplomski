public static double capitalAfterYearsRecursive(double K0, int n, double i,double R) {

    //double K1;
    if(n <= 0)
    {   
        return K0;
    }
    else
    return capitalAfterYearsRecursive(K0, n-1 ,i ,R)*(i+1)+R;
}