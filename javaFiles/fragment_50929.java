@NamedNativeQueries({
  @NamedNativeQuery(
    name = "findNearSphere",
    query = "db.:dbName.find({'location': { '$nearSphere': { '$geometry': { 'type': 'Point', 'coordinates': [:xCoord,:yCoord] }, '$maxDistance': :distance } } }", resultClass = SomeResultClass.class
  )
})

getEm()
  .createNamedQuery("findNearSphere")
    .setParameter("dbName", "User")
    .setParameter("xCoord", 28.051258087158203)
    .setParameter("yCoord", -26.135223388671875)
    .setParameter("distance", 2.0)
  .getResultList();