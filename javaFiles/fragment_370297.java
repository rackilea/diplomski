@JsonIgnoreProperties(ignoreUnknown=true)
public class MyResponseModel {
  private Body body;

  public void setBody(Body body) {this.body = body;}
  public Body getBody() {return body;}

  @JsonIgnoreProperties(ignoreUnknown=true)
  public static class Body {
    private Elems elems;
    // getter and setter for elems 
  }

  @JsonIgnoreProperties(ignoreUnknown=true)
  public static class Elems {
    private Xxx xxx;
    // getter and setter for xxx 
  }

  @JsonIgnoreProperties(ignoreUnknown=true)
  public static class Xxx {
    private String type;
    private String value;

    // getter and setter for type and value 
  }
}