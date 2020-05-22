private static final int WIDE = 10;
private static final int HIGH = 20;
private static final int SIZE = 50;
...
@Override
public Dimension getPreferredScrollableViewportSize() {
    return new Dimension(WIDE * SIZE, HIGH * SIZE);
}