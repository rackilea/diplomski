public static RenderedImage dataUrlToImage(String dataUrl) {
    String data = dataUrl.substring(dataUrl.indexOf(',')+1);        
    byte[] bytes = DatatypeConverter.parseBase64Binary(data);

    try (ByteArrayInputStream in = new ByteArrayInputStream(bytes)) {
        return ImageIO.read(in);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}