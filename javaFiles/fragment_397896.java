@GET
@Path("/generateInfo")
@Produces(MediaType.APPLICATION_JSON)
public String generateInfo(
        @QueryParam("a") String a,
        @QueryParam("b") String b, 
        @QueryParam("date") String date) {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date dateObj = sdf.parse(date);

    return "hello world";
}