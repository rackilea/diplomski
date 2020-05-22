private void loadImage() {
    String b64 = getBASE64Image();
    BufferedImage newImage = null;
    try (ByteArrayInputStream bais = new ByteArrayInputStream(DatatypeConverter.parseBase64Binary(b64))) {
        newImage = ImageIO.read(bais);
    } catch (IOException ex) {
        ...
    }
    image = newImage;
}

private String getBASE64Image() {
    String src = (String) getElement().getAttributes().getAttribute(HTML.Attribute.SRC);
    if (src == null) {
        return null;
    }
    return src.replaceFirst("data:image/png;base64,", "");
}