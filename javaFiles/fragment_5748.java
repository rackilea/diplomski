public interface PersonRepository extends MongoRepository<Person, String>

  @Query("{ 'username' : ?0 }")
  List<Person> findByThePersonsFirstname(String firstname);

}