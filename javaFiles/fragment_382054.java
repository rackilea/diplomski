@Service
public class TestServiceImpl implements TestService {

  public GeneralDAO generalDAO;

  @PersistenceContext
  private EntityManager em;

  public TestServiceImpl(){}

    @Transactional
    public void transactionalTest() {
      Something something = new Something();
      em.persist(something);
    } 
}