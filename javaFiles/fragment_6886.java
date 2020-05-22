public void calcArea( )
{
    // ensure perimeter is up-to-date!
    calcPerimeter();
    double s = (perimeter / 2.0);
    theArea = Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
}