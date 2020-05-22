@Path("/requirement")
public class DimRequirementManagerImpl {
@POST
@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Path("/getreq")
@Override
public String getAllByClientNIsCurrent(AppObject<DimRequirement> appObj) {
try {
     List<DimRequirement> dimreqlist = dimRequirementDao.getAllByClientNIsCurrent(appObj.getClientKey());
     AppObject appObject = new AppObject();
     appObject.setList(dimreqlist);
     JSONObject jsonget = new JSONObject(appObject);
     return jsonget.toString();
     }catch (Exception e) {
        AppObject<DimRequirement> appObject = new AppObject<DimRequirement>();
        appObject.setLicense("12345");
        JSONObject jsonget = new JSONObject(appObject);
        return jsonget.toString();
    }
}}