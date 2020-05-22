public double discrim;

public Quadratic(double a, double b, double c) {
    this.a = a;
    this.b = b;
    this.c = c;
    discrim = (Math.pow(b, 2) - 4*a*c);
}