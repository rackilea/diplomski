public static class P4_Icel_Murad_Rectangle {

    SketchPad Paper = new SketchPad(500, 500);
    DrawingTool pen = new DrawingTool(Paper);

    double x = 0;
    double y = 0;
    double width = 0;
    double height = 0;

    /**
     * Constructor for objects of class P4_Icel_Murad
     */
    public P4_Icel_Murad_Rectangle(double x, double y, double width, double height) {
        // initialise instance variables

        getPerimeter();
        getArea();
        draw();
    }

    // Constructor # 2
    public P4_Icel_Murad_Rectangle() {
        getPerimeter();
        getArea();
        draw();
    }

    public double getPerimeter() {
        double per = (width * 2) + height * 2;
        return per;
    }

    public double getArea() {
        double area = width * height;
        return area;
    }

    public void draw() {
        pen.down();
        pen.turnRight(90);
        pen.forward(x);
        pen.turnLeft(90);
        pen.forward(width);
        pen.turnLeft(90);
        pen.forward(height);
        pen.turnLeft();
        pen.forward(y);

    }
}