public interface FooRepository extends JpaRepository<Foo, Long>{

    @EntityGraph(attributePaths = { "children" })
    @Query("select f from Foo f where f.id = :id")
    Foo getFooWithChildren(@Param("id") long id);

    @EntityGraph(attributePaths = { "pets" })
    @Query("select f from Foo f where f.id = :id")
    Foo getFooWithPets(@Param("id") long id);

    @EntityGraph(attributePaths = { "children", "pets" })
    @Query("select f from Foo f where f.id = :id")
    Foo getFooWithChildrenAndPets(@Param("id") long id);
}