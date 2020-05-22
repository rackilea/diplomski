public class HibernateUserDao extends HibernateDaoSupport implements UserDao {

    private static final String User = User.class.getName();

    public void addUser(User user) {
        getHibernateTemplate().saveOrUpdate(user);
    }

    public void save(User user){
        getHibernateTemplate().saveOrUpdate(user);
    }

    public List<User> get() {

        return getHibernateTemplate().find("from " + User);
    }

    public User get(int id) {
        return (User) (getHibernateTemplate().find("from " + User + " where id = " + id).get(0));
    }

    public User get(String username) {
        return null;
    }
}