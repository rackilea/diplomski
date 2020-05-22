@Repository
public interface LoggerDao extends CrudRepository<Logger, Long> {
    @Query("select t from Logger t where t.user.id=?#{principal.id}")
    List<Logger> findAll();

    @Modifying
    @Query(value = "insert into Logger (redirect,user_id) VALUES (:insertLink,:id)", nativeQuery = true)
    @Transactional
    void logURI(@Param("insertLink") String insertLink, @Param("id") Long id);