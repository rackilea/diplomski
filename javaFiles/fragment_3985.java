public class Ball {
    //...
    private final Ellipse2D.Float areaOfEffect;

    public Ball(Color color, Dimension bounds) {
        //...
        areaOfEffect = new Ellipse2D.Float(-10, -10, dimeter + 20, dimeter + 20);
    }