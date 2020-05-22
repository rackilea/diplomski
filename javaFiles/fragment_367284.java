@Repository(value = "customDao")
public class JPACustomDao implements CustomDao {

  /** entity manager. */
  private EntityManager em = null;

  /**
   * Sets the entity manager.
   * 
   * @param entityManager {@link EntityManager}.
   */
  @PersistenceContext
  public void setEntityManager(EntityManager entityManager) {
    this.em = entityManager;
  }

  @Autowired
  private GenericDatabaseCaller genericStoredProcedure;
}