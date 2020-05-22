@Stateless
@LocalBean
@Local(MAanagerDAO.class)
public class ManagerDaoImpl extends AbstractDAO<X> implements ManagerDAO {

@EJB
PersonDAO personDao;
@PersistenceContext(unitName = "PoyrazPU")
private EntityManager em;