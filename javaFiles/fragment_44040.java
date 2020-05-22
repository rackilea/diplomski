//Child class
public class Square extends Shape {
    private double a;
    public Square(double a) {
        this.a = a;
    }
    @Override
    protected double surface() {
        return a * a;
    }
}

//Main class
class Main {
    public static void main(String[] args) {
        Shape[] shapes = {new Circle(2.0), new Square(3.0)};
        for (Shape shape : shapes)
            System.out.println(shape.toString());
    }
}

//Output
I am a geometric shape and my surface is: 12.566370614359172 and my radius is: 2.0
I am a geometric shape and my surface is: 9.0