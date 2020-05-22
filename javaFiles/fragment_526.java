public static Rational add(Rational x, Rational y){
  Rational z = new Rational();
  int a = (x.denom * y.denom);
  int b = y.num*x.denom + x.num*y.denom;
  z.denom = a/gcd(z.num, z.denom); <--------------
  z.num = b/gcd(z.num, z.denom); <--------------
  return z; 
}