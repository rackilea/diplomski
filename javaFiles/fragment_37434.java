public interface UserRepository extends JpaRepository<UserEntity, Long>, 
      JpaSpecificationExecutor<UserEntity> {

      @Query(value = "select count(v), date(v.createTimestamp) from UserEntity v group by date(v.createTimestamp)", 
             countQuery = "select count(1) from (select count(1) from UserEntity v group by date(v.createTimestamp)) z")
      public List<Object[]> findCountPerDay();
}