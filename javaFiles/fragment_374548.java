public void printArea(Figure f) {
    System.out.println("Area is: " + f.area());
}
...
myObject.printArea(new Rectangle(9, 5));
myObject.printArea(new Triangle(10, 8));