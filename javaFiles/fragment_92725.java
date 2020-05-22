/** An enum of different materials, with different properties and images. */
public enum Material {
  GRASS (5, false, null, true),

  DIRT (5, false, "res/Dirt.png", true), 

  ...

  AIR(1, false, null, false);


  private final int resis;
  private final boolean traspasable;
  private final String imagePath;
  private Image image;
  private final boolean treesCanGrow;

  private Material(int resis, boolean traspasable, String imagePath,
      boolean treesCanGrow) {  
    this.resis = resis;
    this.traspasable = traspasable;
    this.imagePath = imagePath;
    this.treesCanGrow = treesCanGrow;    
  }

  public synchronized Image getTile() throws SlickException {
    if (image == null && imagePath != null) {
      image = new Image(imagePath);
    }
    return image;
  }
}