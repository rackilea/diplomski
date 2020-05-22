class MyImage extends BufferedImage {

    public MyImage(int width, int height, int imageType) {
        super(width, height, imageType);
    }

    public void copyImage(Image image) {
        if (image != null) {
            int width = image.getWidth(null);

            int height = image.getHeight(null); // *** Note change ***

            Graphics g = getGraphics();

            g.drawImage(image, 0, 0, width, height, null);
            g.dispose(); // save resources
        }
    }    
}