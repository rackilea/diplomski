@GET
@Produces(MediaType.APPLICATION_JSON)
public Response getDocumentList(@HeaderParam("Range") String headerRange) {
   int[] range = getRangeFromHeader(headerRange);
   return Response.ok(
        new GenericEntity<List<Document>>( (List<Document>)facade.listByRange(range))
         )
         .header("Content-Range", getContentRangeStr(range)).build();
}