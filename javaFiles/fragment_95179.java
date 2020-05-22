@GET
@Produces({"application/json", "application/xml"})
public Foo getFoo()
{
   return Foo();  //This will be marshalled to XML or JSON depending on what the client requests
}