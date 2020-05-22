@Path("/Plant")
public class PlantResource  extends BaseResource  {

    private List<Plant> plantlist = new LinkedList<Plant>();

    public PlantResource(@Context HttpServletRequest hsr) {
        super(hsr);
    }

    @GET
    @Path("/GetPlantById/plantid/{plantid}")
    @Produces("application/json")
    public String getPlantById(@PathParam("plantid") String plantid) {
        String username = (String)hsr.getAttribute("auth_username");
        // do something 
    }
}