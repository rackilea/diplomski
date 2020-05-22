public static String imageToDataUrl(RenderedImage img) { 
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();

    try {
        ImageIO.write(img, "png", bytes);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }

    String data = DatatypeConverter.printBase64Binary(bytes.toByteArray()),
    //proper data url format
    dataUrl = "data:image/png;base64," + data;

    return dataUrl;
}