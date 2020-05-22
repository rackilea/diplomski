public class PixelsManipulation {

    /* Your Code Here */

    private static BufferedImage getImage(String filename) {
        try {
            /* Code Change */
            InputStream in = PixelsManipulation.class.getResourceAsStream(filename);
            return ImageIO.read(in);
        } catch (IOException e) {
            System.out.println("The image was not loaded. Is it there? Is the filepath correct?");
            System.exit(1);
        }
        return null;
    }
}