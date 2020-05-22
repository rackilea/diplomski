@Path("myPath/servlet/response")
public class MyServiceREST {

    private MyService myService = "*Locate the service in Spring context*";


    @POST
    @Consumes(MediaType.WATHEVER)
    public Wathever receiveResponse(Whatever response){
        if(response!=null){     
            myService.manageResponse(response.getWindowUuid());
        return Response.status(201).build();
        }
        return Response.status(400).build();
    }
}