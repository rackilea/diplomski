@NoRepositoryBean
public interface CommonRepository<T, ID extends Serializable> extends JpaRepository<T, Serializable> {

    @Modifying
    @Query("update #{#entityName} set status = :status")
    int updateStatus(Boolean status);

    // Other methods
}