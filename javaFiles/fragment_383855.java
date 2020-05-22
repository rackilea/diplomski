Complex toComplex(int x, int y)
{
    Complex z = new Complex();
    z.real = min.real + ((x/width) * (max.real - min.real));
    z.imaginary = max.imaginary - ((y/height) * (max.imaginary - min.imaginary));
    return z;
}