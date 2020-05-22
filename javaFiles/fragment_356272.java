import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class BaseDao {
    @PersistenceContext(unitName="MySqlDS")
    private EntityManager entityManager;

    public void save(User user) {
        entityManager.persist(user);
    }
}

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class UserManager {
    @EJB
    private BaseDao baseDao;
    public String createNewUser_test(String name) {
        User user = new User();
        user.setFirstName(name);
        user.setLastName(name);
        user.setRole(UserRole.RegistredUser);
        user.setEmail("email@email.com");

        baseDao.save(user);
        return "";
    }
}