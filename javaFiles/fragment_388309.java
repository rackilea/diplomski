public Complex add(Complex comp1, Complex comp2) {
    double real1 = comp1.getReal();
    double real2 = comp2.getReal();
    double imaginary1 = comp1.getImaginary();
    double imaginary2 = comp2.getImaginary();

    return new Complex(real1+real2, imaginary1 +imaginary2);
}