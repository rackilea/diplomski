public Complex square() {
    double newreal;
    double newimaginary;

    newreal = ((real * real) - (imaginary * imaginary));
    newimaginary = 2 * abs(imaginary * real);

    return new Complex(newreal, newimaginary);
}