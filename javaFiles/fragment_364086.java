@Path("/hello")
public class HelloWorldService {

    @GET
    @Path("/param")
    public Response getMsg(@Context UriInfo urlInfo) {

        String Day = urlInfo.getQueryParameters().getFirst("getSendDay"); //getSendDay getSendTime getSendMonth
        String Time = urlInfo.getQueryParameters().getFirst("getSendTime");
        String Month = urlInfo.getQueryParameters().getFirst("getSendMonth");


        String output = "Jersey say : Month is " + Month + ", Day is " + Day + " and Time is " + Time;

        return Response.status(200).entity(output).build();

    }

}