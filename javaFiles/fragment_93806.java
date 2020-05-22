@POST
     @Path("{membershipExternalId}")
     @Consumes(MediaType.APPLICATION_XML)
     @Produces("application/xml")
     public Response invite(){ //code

     if (fail())
        return Response.status(400).entity(customResponse).build();
}