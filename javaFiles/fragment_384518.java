File inputFile = new File("...");
File outputFile = new File("Test.jpg");
try (InputStream is = new FileInputStream(inputFile)) {
    ImageInputStream iis = ImageIO.createImageInputStream(is);
    BufferedImage image = ImageIO.read(iis);
    try (OutputStream os = new FileOutputStream(outputFile)) {
        ImageOutputStream ios = ImageIO.createImageOutputStream(os);
        ImageIO.write(image, "jpg", ios);
    } catch (Exception exp) {
        exp.printStackTrace();
    }
} catch (Exception exp) {
    exp.printStackTrace();
}