private static long gcd(long a, long b)
{
    while (b > 0)
    {
        long temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}


private static long lcm(long a, long b)
{
    return a * (b / gcd(a, b));
}
...
e = lcm(d1, d2); //denominator
int f1 = e / d1;
int f2 = e / d2;
int g1 = n1 * f1;
int g2 = n2 * f2;
int final1 = g1 + g2;
int k = gcd(final1, e);
int final_nominator = final1 / k;
int final_denominator = e / k;