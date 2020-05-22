public Rational(long a, long b){
 numerator = a;
 denominator = b;
 boolean isNegative = false;
 if (numerator*denominator < 0)
 isNegative = true;
 long gd = gcd(numerator, denominator);
 numerator /= gd;
 denominator /= gd;
}