BufferedImage oldRGBA= null;
    try {
        oldRGBA= ImageIO.read(new URL("http://yusufcakmak.com/wp-content/uploads/2015/01/java_ee.png"));
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    final int width = 1200;
    final int height = 800;
    BufferedImage newRGB = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    newRGB .createGraphics().drawImage(oldRGBA, 0, 0, width, height, null);
    try {
        ImageIO.write(newRGB , "PNG", new File("your path"));

    } catch (IOException e) {}