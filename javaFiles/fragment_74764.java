double d = -542.347543274623876;
System.out.println(d);
int n = 2; // decimal digits

double p = Math.pow(10,n);
d = Math.floor((int)(p*d))/p;
System.out.println(d);