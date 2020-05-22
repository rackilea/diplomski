@GET
@Produces(MediaType.APPLICATION_OCTET_STREAM)
public Response getDocumentContents(@HeaderParam("your header param") final YourHeaderParamUserType headerParam) {
    byte[] outByteArray = ... obtain byte array
    return Response.ok()
           .entity(outByteArray)
           .build();
}