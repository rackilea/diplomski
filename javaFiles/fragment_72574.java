List<Shape> lst = new ArrayList<Shape>();

Shape c1 = new Circle();
Shape t1 = new Triangle();
lst.add(c1);
lst.add(t1);

for (Shape shape : lst) {
    if (shape instanceof Circle) {
        // handle the circle
    }
    else if (shape instanceof Triangle) {
       // handle the Triangle
    }
}