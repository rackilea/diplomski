File inputFile = new File("/path/to/image.png");
File outputFile = new File("Test.jpg");
try (InputStream is = new FileInputStream(inputFile)) {
    BufferedImage image = ImageIO.read(is);
    try (OutputStream os = new FileOutputStream(outputFile)) {
        ImageIO.write(image, "jpg", os);
    } catch (Exception exp) {
        exp.printStackTrace();
    }
} catch (Exception exp) {
    exp.printStackTrace();
}