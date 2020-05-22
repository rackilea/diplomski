@POST    
    @Path("/CreateAccount")
    @Consumes("custom format")
    public Response createAccount(@Context HttpServletRequest req,Account acc) {

        saveAccount(acc); // here acc object is returned from your custom unmarshaller 
        return Response.ok().build();
    }