@Repository
public interface TournamentRepository extends PagingAndSortingRepository<Tournament, Long> {

    @Query("Select t from Tournament t where t.startDate <= CURRENT_DATE and t.endDate >= CURRENT_DATE")
    Page<Tournament> findByStartBeforeAndEndAfter(Pageable page);

}