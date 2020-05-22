@Transactional
public interface MyObjectRepository extends JpaRepository<MyObject, Integer>, MyObjectRepositoryCustom {

    List<MyObject> findByName(String name);

    @Query("select * from my_object where name = ?0 or middle_name = ?0")
    List<MyObject> findByFirstNameOrMiddleName(String name);
}