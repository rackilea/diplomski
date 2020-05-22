//Parent class
public abstract class Shape {
    protected abstract double surface();
    @Override
    public String toString() {
        return "I am a geometric shape and my surface is: " + surface();
    }
}

//Child class
public class Circle extends Shape {
    private double r;
    public Circle(double r) {
        this.r = r;
    }
    @Override
    public String toString() {
        return super.toString() + " and my radius is: " + r;
    }
    @Override
    protected double surface() {
        return r * r * Math.PI;
    }
}

//Main class
class Main {
    public static void main(String[] args) {
        Shape c = new Circle(2.0);
        System.out.println(c.toString());
    }
}

//Output
I am a geometric shape and my surface is: 12.566370614359172 and my radius is: 2.0