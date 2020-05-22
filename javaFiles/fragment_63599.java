@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)

public class RegisterUser implements RegisterUserLocal {

 @PersistenceUnit(unitName = "SCBCDEntities")
 private EntityManagerFactory factory;

 public void registerNewUser(String username, String password) {

  EntityManager entityManager = factory.createEntityManager();
  EntityTransaction entityTransaction = entityManager.getTransaction();
  entityTransaction.begin();

  User user = new User();
  user.setPassword(password);
  user.setUsername(username);

  entityManager.persist(user);
  entityTransaction.commit();
 }
}