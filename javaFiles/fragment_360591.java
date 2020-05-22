public class CustomBadRequest extends Exception {

  private String uriInfo;

  public CustomBadRequest() {
    super("Invalid Request. Please try again with the valid request");
  }

  public CustomBadRequest(String uriInfo, String message) {
    super(message);
    this.uriInfo = uriInfo;
  }

  public String getUriInfo() {
    return uriInfo;
  }
}