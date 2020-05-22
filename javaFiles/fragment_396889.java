public static double[] foo(double[] salaries, double riseRate){
    for(double salary : salaries){
        salary *= riseRate;
    }  
    return salaries;
}