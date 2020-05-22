@Repository
public interface ManagerRepository extends MongoRepository<Employee, String>

  @Query(value="{ '_class' : 'com.igmtechnology.gravity.core.init.test.Manager' }")
  List<Person> findAllManagers();

}