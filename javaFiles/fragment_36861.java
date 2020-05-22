public interface ARepository extends JpaRepository<A, Long> {
    @Query(
        value = "select new package.AwithBCount(count(b.id) as bCount,c) from A a join a.bes b group by a",
        countQuery = "select count(a) from A a"
    )
    Page<AwithBCount> findAllWithBCount(Pageable pageable);

    @Query(
        value = "select new package.AwithBCount(count(b.id) as bCount,c) from A a join a.bes b group by a order by bCount asc",
        countQuery = "select count(a) from A a"
    )
    Page<AwithBCount> findAllWithBCountOrderByCountAsc(Pageable pageable);

    @Query(
        value = "select new package.AwithBCount(count(b.id) as bCount,c) from A a join a.bes b group by a order by bCount desc",
        countQuery = "select count(a) from A a"
    )
    Page<AwithBCount> findAllWithBCountOrderByCountDesc(Pageable pageable);
}