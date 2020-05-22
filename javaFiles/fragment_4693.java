public Fraction divide (Fraction f){
   int den1 = this.denominator;
   int den2 = f.denominator;
   int num1 = this.numerator;
   int num2 = f.numerator;

   int num3 = num1 * den2;
   int den3 = den1 * num2;

   Fraction f2 = new Fraction (num3, den3);
   ...