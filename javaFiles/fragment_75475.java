public void add(Complex d) {    // adds complex number d to this number
    this.re += d.getReal();     // add real part
    this.im += d.getImaginary();// add imaginary part
}
public void square(){
    double temp1 = this.re * this.re; // real * real
    double temp2 = this.re * this.im; // real * imaginary (will be the only one to carry around an 'i' wth it
    double temp3 = -1 * this.im * this.im; // squared imaginary so multiply by -1 (i squared)
    this.re = temp1 + temp3; // do the math for real
    this.im = temp2;         // do the math for imaginary
}

public double modulusSquared() { // gets the modulus squared
    return Math.sqrt(this.re * this.re + this.im * this.im); 
}