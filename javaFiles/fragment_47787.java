Robot robot = new Robot();
    Rectangle captureSize = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
    BufferedImage bufferedImage = robot.createScreenCapture(captureSize);
    // ...

    int color = image.getRGB(x, y);

    int  red = (color & 0x00ff0000) >> 16;
    int  green = (color & 0x0000ff00) >> 8;
    int  blue = color & 0x000000ff;
    // ...