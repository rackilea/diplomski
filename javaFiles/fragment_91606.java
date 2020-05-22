@Repository
public interface LogRepository extends JpaRepository<Log, Long> {
    @Query("SELECT l FROM Log AS l")
    List<Log> findAll();

    @Query("SELECT new test.pckg.dto.LogDTO(l.message, l.date) FROM Log l WHERE l.level = :level")
    List<LogDTO> fetchLogsByLevelAsDTO(@Param("level") String level);
}