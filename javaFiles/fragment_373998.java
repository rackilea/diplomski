@NoRepositoryBean
public interface TemporalRepository<T extends Temporal> extends JpaRepository<T, Long> {
    List<T> findByTemporalCode(Long temporalCode);

    List<T> findByTemporalCodeAndDateBeginBeforeAndDateEndAfter(Long temporalCode, Date dateBegin, Date dateEnd);

    @Query("select t from #{#entityName} t 
        where (t.dateBegin < ?1 or t.dateBegin is null)
        and (t.dateEnd < ?1 or t.dateEnd is null)")
    List<T> findByDate(Date dateBegin);
}