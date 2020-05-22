public class Building {

    private CityScape cityScape;
    private Rectangle r;
    private BufferedImage img;

    public Building(CityScape cityScape, Rectangle r) {
        this.cityScape = cityScape;
        this.r = r;
        this.img = draw();
    }

    private BufferedImage draw() {
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // you will need to set width and height!

        Graphics2D g2d = img.createGraphics();
        // draw the image as before, but to the BufferedImage this time

        return img; // image of the buildings
    }

    public BufferedImage getImg() {
        return this.img; // returns the BufferedImage
    }

    private static boolean randBool() {
        return Math.random() < 0.5;
    }
}