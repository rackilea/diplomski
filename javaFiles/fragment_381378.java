public abstract class GenericDataResource<T extends GenericModel> {
  public Response findAll(GenericEntity<List<T>> token) {
    Query query = em.createNamedQuery(modelClass.getSimpleName() + ".findAll");
    List<T> list = query.getResultList();
    return Response.ok(token).build();
  }
}