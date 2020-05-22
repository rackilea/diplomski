@Override
public double getArea()
{
    double s = this.side1 + this.side2 + this.side3;
    double area = Math.sqrt((s - this.side1) - (s - this.side2) - (s - this.side3));
    return area;
}

@Override
public double getPerimeter()
{
    double peri = this.side1 + this.side2 + this.side3;
    return peri;
}