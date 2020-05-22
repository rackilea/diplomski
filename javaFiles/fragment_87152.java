public class JPEGFileToPNG {

public static void main(String[] args) throws IOException {

    File imageFile = new File("C:\\Users\\user\\Desktop\\encryption\\d.jpg");
    File compressedImageFile = new File("C:\\Users\\user\\Desktop\\encryption\\compress.png");

    BufferedImage image = ImageIO.read(imageFile.toURI().toURL());

    ImageIO.write(image, "png", compressedImageFile);

}