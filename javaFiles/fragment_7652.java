public interface AttendsRepository extends GraphRepository<Attends>{

    @Query("Match(p:Person {personId:{0}})-[a:ATTENDS]->(e:Event) return a")
    Iterable<Attends> findByPersonId(String personId);

}