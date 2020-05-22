public static class Square extends Figure {

    public Square() {
        super(FigureType.Square);
    }

    @Override
    public void draw() {
        System.out.println("Square");
    }
}

public static class Circle extends Figure {

    public Circle() {
        super(FigureType.Circle);
    }

    @Override
    public void draw() {
        System.out.println("Circle");
    }

    public float getRadius() {
        return 8;
    }
}