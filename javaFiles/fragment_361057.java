public class Keying extends JPanel {

    //public Rectangle character;
    private java.awt.BufferedImage character;
    private java.awt.Point characterLocation;
    //...

    public Keying(Display f, Images i) throws IOException
    {
        character = javax.ImageIO.read(...);
        characterLocation = new Point(0, 0);
        //...