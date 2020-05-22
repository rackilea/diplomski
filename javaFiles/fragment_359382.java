public class Metadata {

  private final String description;
  private final String imageName;

  public Metadata(String description, String imageName) {
    this.description = description;
    this.imageName = imageName;
  }
  public String getDescription() {return description;}
  public String getImageName() {return imageName;}

  @Override
  public String toString() {
    return description + " " + imageName;
  }
}