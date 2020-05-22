@Repository
@Transactional
public class DaoImpl implements DaoCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public User create(User user) {
        em.persist(user);
        return user;
    }
}