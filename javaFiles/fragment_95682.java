@Path("basepath")
public class YourBaseResource {

  //this gets injected after the class is instantiated by Jersey    
  @Context
  UriInfo uriInfo; 

  @Path("a/b")
  @GET
  public Responce method1(){
    return Response.ok("blah blah").build();
  }

  @Path("a/b/c")
  @GET
  public Response method2(){
    UriBuilder addressBuilder = uriInfo.getBaseUriBuilder();
    addressBuilder.path("a/b");
    return Response.seeOther(addressBuilder.build()).build();
  }

}