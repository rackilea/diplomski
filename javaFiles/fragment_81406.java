@Stateless
@Singleton
public class ManagerDaoImpl extends AbstractDAO<X> implements ManagerDAO {

@EJB
PersonDAO personDao;
@PersistenceContext(unitName = "PoyrazPU")
private EntityManager em;