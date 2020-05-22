public class ColourFullShape {
    private Shape shape;
    private boolean state;

    public ColourFullShape(Shape shape, boolean state) {
        this.shape = shape;
        this.state = state;
    }

    public boolean getState() {
        return state;
    }

    public Shape getShape() {
        return shape;
    }

}