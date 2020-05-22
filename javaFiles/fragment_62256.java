public class AB extends AA {
  public String getValue() { 
      String superS = super.getValue();
      return superS + "bar"; 
  }
}