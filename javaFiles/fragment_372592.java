public static long  GetFWDwrp(Double fwd[]) {
    double tmp[]=new double[1];
    long retval = MyClass.GetFWD(tmp);      
    fwd[0] = tmp[0];
    return retval;
}