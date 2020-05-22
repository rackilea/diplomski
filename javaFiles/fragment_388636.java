@POST
@Path("/msisdn")
public Response verify(@Context HttpHeaders headers, MsisdnVerifyRequestBean reqBean) {
    if (personDao == null) {
        return Response.status(506).entity("DI error").build();
    }
    String userAgent = headers.getRequestHeader("user-agent").get(0);
    if(userAgent.contains("ipad")){
    reqBean.setType(2);
    }