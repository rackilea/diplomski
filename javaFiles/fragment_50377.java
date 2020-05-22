@Repository
public interface MyRepository extends CrudRepository<MyEntity, Long> {

  @Procedure(name = "test.home_test_pkg.show_people_data")
  List<MyEntity> getPeopleData(@Param("my_param_in") String myParamIn);
}