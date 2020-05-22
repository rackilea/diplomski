public class ImageLocator {
    public final static String IMAGE_NAME1 = "MyImage1.jpg";

    public static Image getImage(final String name) {
        URL url = ImageLocator.class.getResource(name);
        Image image = Toolkit.getDefaultToolkit().createImage(url);
        // ensure the image is loaded
        return new ImageIcon(image).getImage();            
    }
}