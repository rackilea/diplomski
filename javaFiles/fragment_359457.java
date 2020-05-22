for (File png : pngs) {

    try {
        BufferedImage img = ImageIO.read(png);
        int width = img.getWidth();
        int height = img.getHeight();
        System.out.println(png.getParent() + ", " + png.getName() + " @ " + width + "x" + height);
    } catch (IOException e) {
        System.out.println("Bad image: " + png);
        e.printStackTrace();
    }

}