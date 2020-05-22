@GET
@Produces({MediaType.APPLICATION_JSON, 
           MediaType.APPLICATION_XML})
public Response foo()
{
     PersonObj obj = new PersonObj();

     //Do something...
     return Response.ok().entity(obj).build();
}