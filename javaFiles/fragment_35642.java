byte[] data = new byte[]{
        (byte) 0b00000011/*Blue*/, (byte) 0b11100011/*Purple*/,
        (byte) 0b11100011/*Purple*/, (byte) 0b11111111/*White*/};//This is the "image"

    int width = 2, height = 2;

    DataBufferByte buffer = new DataBufferByte(data, data.length);
    int[] bandMasks = {0b11100000, 0b00011100, 0b00000011};

    WritableRaster raster = Raster.createPackedRaster(buffer, width, height, width, bandMasks, null);

    BufferedImage image = new BufferedImage(new DirectColorModel(8, 0b11100000, 0b00011100, 0b00000011), raster, false, null);

    JFrame frame = new JFrame("Test");
    Canvas c = new Canvas();
    frame.add(c);
    frame.setSize(1440, 810);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    while (true) {
        Graphics g = c.getGraphics();
        g.drawImage(image, 0, 0, image.getWidth() * 40, image.getHeight() * 40, null);
    }