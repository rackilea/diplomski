public interface MyRepository extends ReactiveCassandraRepository<MyClass, String> {
  @Query("select * from my_keyspace.my_table where solr_query = ?0")
  Mono<Slice<MyClass>> findMono(String solrQuery, Pageable page);
}

Mono<Slice<MyClass>>  repository.findMono(queryString, CassandraPageRequest.first(20));