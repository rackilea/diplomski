@Stateless
public class UserService {

    @PersistenceContext
    private EntityManager em;

    public User find(Integer id) {
        return em.createNamedQuery("getUserById", User.class)
            .setParameter("id", id)
            .getSingleResult();
    }

}