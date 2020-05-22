@DELETE
@Path("/properties/{property_id}")
public Response deleteProperty(
    @PathParam("property_id") int propertyId,
    @QueryParam("deleted_by") String deletedBy)
{
    ...
}