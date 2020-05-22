public Polynomial integrate()
{
    Polynomial integral = new Polynomial(this.degree + 1);
    for (int i = 1; i <= this.degree+1; i++)
    {
            integral.coefficients[i] = (this.coefficients[i - 1] / i);
    }
    return integral;
}

// a method that find a Polynomial integral over the interval a to b
public double integration(double a, double b)
{
    Polynomial integral = integrate();
    return (integral.evaluate(b) - integral.evaluate(a));
}