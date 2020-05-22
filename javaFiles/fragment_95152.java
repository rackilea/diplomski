public interface Tree{
    public void grow();
}

abstract class AbstractTree implements Tree {

    // Do the values of these fields ever change? If not,
    // then make them final, and set them only in the
    // constructor
    private final String barColor;
    private final int maxHeight;
    private final boolean evergreen;

    protected AbstractTree(...) { ... }

    // Subclasses are only allowed to read (but not write) these fields
    protected final String getBarColor() { return barColor; }
    protected final intgetMaxHeight() { return maxHeight; }
    protected final boolean isEvergreen() { return evergreen; }
}