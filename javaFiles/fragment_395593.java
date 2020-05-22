public interface MyRepo extends JpaRepository<MyEntity, Long> {

    @Query("select e from MyEntity e where ?#{@myRepo.myMethod(#param1)} is true")
    List<MyEntity> entities = getEntity(@Param("param1") String param);

    default boolean myMethod(String param) {...}
}