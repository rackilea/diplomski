import org.apache.commons.io.IOUtils;

@Path("/item")
public class MyResource {

  @GET
  @Path("/object/{id}")
  @Produces("image/jpeg")
  public byte[] getImageRepresentation(@PathParam("id") int id) {
     byte[] bytes = null;
     switch (id) {
        case 1: bytes = IOUtils.toByteArray(this.getClass().getResourceAsStream("/img/image01.jpg"));break;
        case 2: bytes = IOUtils.toByteArray(this.getClass().getResourceAsStream("/img/image02.jpg"));
      }
      return bytes;
  }

}