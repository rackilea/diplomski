public class Circle {
public static void main(String[] args) {
    Circle myCircle = new Circle();
    myCircle.display();
}

double radius;
double diameter;
double area;

public Circle() {
    radius = 1;
    diameter = radius * radius;
    area = Math.PI * radius * radius;
}

public void setRadius(double radius) {
    this.radius = radius;
    diameter = radius * radius;
    area = Math.PI * (radius * radius);

}

public double getRadius() {
    return radius;
}

public void display() {
    System.out.println("The radius is " + radius);
    System.out.println("The diameter is " + diameter);
    System.out.println("The area is " + area);
}