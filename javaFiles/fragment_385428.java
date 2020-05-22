public class Veldmaker extends Canvas {

    private int numRows;
    private int numCols;
    //private Graphics2D images; // You don't need this
    private BufferedImage img; // But you will need this to load your image once

    public Veldmaker(int numRows, int numCols, String image) {
        this.numRows = numRows;
        this.numCols = numCols;
        setSize(numRows, numCols); // this may work, depends on your Frame layout

        // now I put in the content of your tekenVeld method
        // image loading should be done in constructor

        String filename = System.getProperty("user.dir")
        + java.io.File.separator + "src" + java.io.File.separator + "Sokoban"
        + java.io.File.separator + "Images" + java.io.File.separator + image
        + ".gif";

        // Why this if you have already an image?
        // InputStream stream = this.getClass().getClassLoader().getResourceAsStream("Muur.gif");

        try {
            img = ImageIO.read(new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // we do this in paint method
        // images = (Graphics2D) img.getGraphics();
        // images.drawImage(img, locatie.x, locatie.y, null);
    }

    @Override 
    public void paint(Graphics g){
        g.drawImage(img, 0, 0, null);
    }
}