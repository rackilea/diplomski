@POST
@Path("/token")
@Timed
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Response getToken(UserTokenRequest userTokenRequest) throws Exception {
UserTokenResponse response = userService.getToken(userTokenRequest);
     if (response != null) {
       return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            .ok(response, MediaType.APPLICATION_JSON_TYPE)
            .build();
    } else {
        return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid Auth credentials").header("WWW-Authenticate", "Basic realm=\"Auth\"").type(MediaType.TEXT_PLAIN_TYPE).build();
    }

}