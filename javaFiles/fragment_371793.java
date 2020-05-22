class Fraction
{
public:
  Fraction(int num, int den = 1);
  Fraction operator+=(Fraction const& other);
  Fraction operator*=(Fraction const& other);
  // ...
private:
  int numerator, denominator;
};

Fraction::Fraction(int num, int den):
  numerator(num),
  denominator(den)
{
  normalize();
}

Fraction Fraction::operator+=(Fraction const& other)
{
  int new_den = denominator*other.denominator;
  numerator = numerator*other.denominator + denominator*other.numerator;
  denominator = new_den;
}

Fraction Fraction::operator*=(Fraction const& other)
{
  numerator *= other.numerator;
  denominator *= other.denominator;
  normalize();
}

void Fraction::normalize()
{
  int factor = gcd(numerator, denominator);
  numerator /= factor;
  denominator /= factor;
}