final BufferedImage original = ImageIO.read(new File("some-image.jpg");

final PaletteData palette =
        new PaletteData(0x0000FF, 0x00FF00, 0xFF0000);

// the last argument contains the byte[] with the image data
final ImageData data = new ImageData(original.getWidth(), original.getHeight(),
        24, palette, 4,
        ((DataBufferByte) original.getData().getDataBuffer()).getData());

final Image converted = new Image(getDevice(), data);