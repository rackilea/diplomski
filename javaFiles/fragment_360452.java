public class Facade {
  private final PropertyResource propertyResource;
  public Facade() {
    propertyResource = new PropertyResource();
  }
  @GET
  @Path("somepath")
  public Tenant something() {
    return propertyResource.something();
  }
}