/**
 * Provides access to image resources at runtime.
 */
@DefaultExtensions(value = {".png", ".jpg", ".gif", ".bmp"})
@ResourceGeneratorType(ImageResourceGenerator.class)
public interface ImageResource extends ResourcePrototype {
//...