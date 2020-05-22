@Path("/lookupDesignations") // or you complete path
@GET
@Produces(value = MediaType.APPLICATION_XML)
public Response getLookupDesignation(@QueryParam("codeSystemUid") String codeSystemUid, @QueryParam("conceptCode") String conceptCode) {
     // now you have codeSystemUid and conceptCode as String
     // create you entity or list for you entity to return as XML
     return Response.ok().entity(yourEntity).build();
}