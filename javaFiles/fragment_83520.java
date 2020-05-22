public interface SomeRepository
            extends JpaRepository<EntityMappedViaHibernate, String> {

@Query("select id, someColumnA from EntityMappedViaHibernate where id = :paramOne")
List<Object[]> getListData( @Param(value = PARAM_ONE) final String paramOne, Pageable pageable );
}