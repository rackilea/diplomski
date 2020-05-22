public interface PersonRepository extends CrudRepository<Person, Long> {

    @EntityGraph(attributePaths = { "password", "roles" })
    public List<Person> findAll();

}