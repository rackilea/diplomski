public interface Drawable {
    void draw(GraphicsContext g);
}

public class Gallows implements Drawable {
    @Override
    public void draw(GraphicsContext g) {
        // call what you need to draw the gallows.
    }
}

public class Head implements Drawable {
    @Override
    public void draw(GraphicsContext g) {
        // call what you need to draw the head.
    }
}