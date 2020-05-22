package test.mockito;

import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    public static final Logger LOG = LoggerFactory.getLogger(UserDAOImpl.class);
    private Session session;

    public UserDAOImpl(Session session) {
        this.session = session;
    }

    @Override
    public void addUser(String username, String password) {
        String encryptedPassword = Utils.encrypt(password);
        User user = new User(username, encryptedPassword);
        session.beginTransaction();
        try {
            session.save(user);
            System.out.println(user.getPassword());
            session.getTransaction().commit();
        } catch (SQLGrammarException e) {
            session.getTransaction().rollback();
            if(LOG != null)LOG.error("Cannot save user", e);
        } finally {
            session.close();
        }
    }

    @Override
    public List<String> getUsers() {
        session.beginTransaction();
        List<String> results = new ArrayList<String>();
        String hql = "select username from User";
        Query query = null;
        try {
            query = session.createQuery(hql);
            results = query.list();
        } catch (HibernateException e) {
            if(LOG != null)LOG.error("Cannot execute query", e);
        }
        return results;
    }
}