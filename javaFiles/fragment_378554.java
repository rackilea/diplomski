class myfunc {
    public myfunc(int nn, int cc, double aalpha) {...}

    public double eval(double p) {
        double sum = 1;
        double term = 1;
        for(int i = 1; i<=c; i++) {
             term *= (n*p)/i;
             sum += term;
         }
         return sum*Math.exp(-n*p) - alpha;
     }
}

..............

public double secant(myfunc f, double a, double b) {
    double fa = f.eval(a);
    double fb = f.eval(b);
    while(Math.abs(b-a)>1e-10) {
        double c = (a*fb-b*fa)/(fb-fa);
        a=b; fa = fb;
        b=c; fb = f.eval(b);
    }
    return b;
}