@GET
@Path("/PATH")
@Produces(MediaType.APPLICATION_JSON)
public List<MyClass> getListOfMyClass(JSONArray myClassIdList)
{
  return getMyClassList(JAXBListPrimitiveUtils.<Integer>JSONArrayToList(myClassIdList) );
}