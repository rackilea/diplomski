public class ImageUtils {

    public final IImageDimensionOperations dimension;
    public final IImageColorOperations color;

    public ImageUtils() {
        this(new ImageDimensionOperations(),
             new ImageColorOperations());
    }    

    public ImageUtils(IImageDimensionOperations dimension,
              IImageColorOperations color) {
        this.dimension = dimension;
        this.color = color;
    }

    /* Nothing else needed in this class, ever! */

}