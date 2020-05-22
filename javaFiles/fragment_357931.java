public abstract class Polygon {
   private double Length;
   private double Width;
   private double Height;

public Polygon(double base, double height, double length) {
           this.Width = base;
           this.Height = height;
           this.Length = length;
}

public abstract double calcArea();
public abstract double calcPerimeter();


public double getWidth() {
    return this.Width;
}

public void setWidth(double Width){
    this.Width = Width;

}

public double getHeight() {
    return this.Height;

}
public void setHeight(double Height){
    this.Height = Height;
}
public double getLength() {
    return this.Length;
}

public void setLength(double length){
    this.Length = length;
 }
}