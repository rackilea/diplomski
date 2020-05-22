@POST
@Path("/pass")
@Consumes(MediaType.APPLICATION_JSON)
public Response sampleApi(final Incoming bean){
    onlineThreadPool.getThreadPoolExecutor().submit(new Runnable(){
       @Override public void run(){
          //do some processing on bean
          File file = getUserData(bean);
         //do some processing on file
       }});
    return Response.status(200).entity("OK").build();
}