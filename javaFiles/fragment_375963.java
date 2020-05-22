@Repository
public interface DocutoolsUserRepository  extends JpaRepository<DocutoolsUser, Long> {

// where Account not null
 public List<DocutoolsUser> findByAccountIsNotNull();

}