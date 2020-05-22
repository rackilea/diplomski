@Attachment(value = "Page Screenshot", type = "image/png")
public static byte[] saveScreenshotPNG(String path) {
    File file = new File(path);
    BufferedImage bufferedImage = ImageIO.read(file);

    byte[] image = null;
    try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
        ImageIO.write(bufferedImage, "png", bos);
        image = b.toByteArray();
    } catch (Exception e) { }

    // if decoding is not necessary just return image
    return image != null ? Base64.getMimeDecoder().decode(image) : null;
}