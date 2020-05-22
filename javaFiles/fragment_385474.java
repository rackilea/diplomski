Entity
@Cache(expiry = 3600000, // 1 hour size = 10000)
@NamedQueries({
  @NamedQuery(name = "Person.findByPK", query = "select p from Person p " +
  "where p.name=:NAME",
  hints = {
    @QueryHint(name = QueryHints.CACHE_USAGE,
    value = CacheUsage.CheckCacheThenDatabase),
    @QueryHint(name = QueryHints.QUERY_TYPE, value = QueryType.ReadObject)
  }
})