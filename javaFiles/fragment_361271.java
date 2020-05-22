@Stateless
public class UserFacade extends AbstractFacade<User, String> {

    @PersistenceContext(unitName = "MyPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }

    // Other methods of this service

}