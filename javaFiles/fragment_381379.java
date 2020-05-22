@GET
@Produces(MediaType.APPLICATION_JSON)
public Response findAll() {
  Query query = em.createNamedQuery(modelClass.getSimpleName()+".findAll");
  List<T> list = query.getResultList();
  return Response.ok(new GenericEntity(list, getType())).build();
}