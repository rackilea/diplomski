public static ImageIcon getPNGIconFromFile(File file) throws IOException {
    BufferedImage bitmap = ImageIO.read(file);
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    ImageIO.write(bitmap, "PNG", bytes);
    return new ImageIcon(bytes.toByteArray());
}