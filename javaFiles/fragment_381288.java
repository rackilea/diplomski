public Complex add(Complex other) {
    Complex result = new Complex();
    result.realPart = this.realPart + other.realPart;
    result.imaginaryPart = this.imaginaryPart + other.imaginaryPart;

    return result;
}