@Stateless
public class UserHandling {
  @PersistenceContext(unitName = "SSIS2")
  private static EntityManager em;

  @Resource
  private UserTransaction utx;

  @EJB
  UserHandling uh; RoleHandling rh; 

  public User getUser(int userId) {
    User userObject = em.find(User.class, userId);
    return userObject;
  }
}