public enum State {
  HAPPY("path/image.gif");

  private final Image image;     

  private State(String path)
  {
      this.image = ...
  }

  public Image getImage()
  {
      return image;
  }
}