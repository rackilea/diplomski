@Repository
public class MyEntityDAO {

     @PersistenceContext
     private EntityManager entityManager;

     public void save(MyEntity myEntity){
          entityManager.persist(myEntity);
          entityManager.flush();
     }
}