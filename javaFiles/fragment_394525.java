@Stateless    //This made trick
@Path("/service")
public class AffableBeanService {
    //EJB Injection
    @EJB
    CategoryFacade categoryFacade;

    @GET
    @Path("/categories/{categoryId}")
    public String categories(@PathParam("categoryId") String categoryId) {
         selectedCategory = categoryFacade.find(Short.parseShort(categoryId));
    }
}