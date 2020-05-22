public class ImageUtils implements IImageDimensionOperations,
                                   IImageColorOperations {

    private final IImageDimensionOperations dimension;
    private final IImageColorOperations color;

    public ImageUtils() {
        this(new ImageDimensionOperations(),
             new ImageColorOperations());
    }
    /* etc. */
}