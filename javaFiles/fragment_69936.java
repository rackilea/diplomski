package somemodule;

public enum StandardImageType implements ImageType {
    IMAGE,
    VECTOR,
    RASTER,
    HANDWRITING,
    ICON,
    LOGO,
    SEAL,
    RULE,
    BARCODE;

    public static ImageTypes provider() {
        return StandardImageType::values;
    }
}