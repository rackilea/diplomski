@Repository
public class CarDaoImpl implements CarDao {

    protected EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public List<Car> getCars() throws DataAccessException {
        Query query = getEntityManager().createQuery("select c from Car c");
        List<Car> resultList = query.getResultList();
        return resultList;
    }
    @Transactional
    public Car getCar(Long carId) throws DataAccessException {
        return getEntityManager().find(Car.class, carId);
    }