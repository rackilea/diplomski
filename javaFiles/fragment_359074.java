public class ImageExample
{
    public static void main ( String[] args ) throws IOException
    {
        final BufferedImage image = new BufferedImage ( 1000, 1000, BufferedImage.TYPE_INT_ARGB );
        final Graphics2D graphics2D = image.createGraphics ();
        graphics2D.setPaint ( Color.WHITE );
        graphics2D.fillRect ( 0,0,1000,1000 );
        graphics2D.setPaint ( Color.BLACK );
        graphics2D.drawOval ( 0, 0, 1000, 1000 );
        graphics2D.dispose ();

        ImageIO.write ( image, "png", new File ( "C:\\image.png" ) );
    }
}