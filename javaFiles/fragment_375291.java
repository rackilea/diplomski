@Autowire 
public class Sampleclass {
    @Autowired
    private PropertyItemMapper daoImpl;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("id/{id}")
    public PropertyItem getPropertyItem(@PathParam("id") Integer id){
        return daoImpl.selectResourcesById(id);
    }

}