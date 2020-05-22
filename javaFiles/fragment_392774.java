public class TileList extends JPanel {

  //.... deleted for brevity

  BufferedImage tileset[];

  public void loadAndSplitImage (File loadImage) {
    try{
        image = ImageIO.read(loadImage);
    }catch(Exception error) {
        System.out.println("Error: cannot read tileset image.");
    }// end try/catch
    col = image.getWidth()/width;
    row = image.getHeight()/height;
    BufferedImage tileset[] = new BufferedImage[col*row]; // *** re-declaring variable!
  }