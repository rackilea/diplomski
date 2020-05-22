public class ImageUtils {

    private final IImageDimensionOperations dimension;
    private final IImageColorOperations color;

    public ImageUtils() {
        this(new ImageDimensionOperations(),
             new ImageColorOperations());
    }

    /**
     * Parameterized constructor which supports dependency injection, very handy
     * way to ensure that class always has the required accompanying classes and
     * this is easy to mock too for unit tests.
     */
    public ImageUtils(IImageDimensionOperations dimension,
                      IImageColorOperations color) {
        this.dimension = dimension;
        this.color = color;
    }

    /* utility methods go here */

}