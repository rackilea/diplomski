@Entity
public class Article {
 // ...
  private URI uri;

  public void setUri(URI uri) {
    this.uri = uri;
  }

  public URI getUri() {
    return this.uri;
  }
}