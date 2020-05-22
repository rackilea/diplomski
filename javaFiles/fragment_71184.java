public interface IImageColorOperations {

    BufferedImage adjustHue(float difference, BufferedImage original);

    BufferedImage adjustBrightness(float difference, BufferedImage original;)

    BufferedImage adjustContrast(float difference, BufferedImage original);

}

public interface IImageDimensionOperations {

    BufferedImage setHeight(int newHeight, BufferedImage original);

    BufferedImage setWidth(int newWidth, BufferedImage original);

}