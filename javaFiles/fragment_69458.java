interface Painter<T> {
    // ...
}

public enum Painters implements Painter<Component> {
    Background(getBackgroundPainter()),
    InactiveBackground(getInactiveBackgroundPainter()),
    DesktopBackground(getBackgroundPainter());

    private Painter<Component> _painter;

    // ...
}

Painter somePainter = Painters.Background;