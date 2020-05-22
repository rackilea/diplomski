public class Triangle extends Polygon {

    public Triangle(double base,double height,double length){
      super(base,height,length);  
     }


    @Override
    public double calcArea() {
        return 0.5 * this.getWidth() * this.getHeight();
        }
    @Override
    public double calcPerimeter() {
        return this.getLength() + this.getLength() + this.getLength();
    }


    //tests

    public static void main(String [] args) {
        Triangle triangle = new Triangle(10,20,30);
        System.out.println(triangle.getWidth() + " width of a triangle");
        System.out.println(triangle.getHeight() + " height of a triangle");
        System.out.println(triangle.getLength() + " length of a triangle");

    }
}