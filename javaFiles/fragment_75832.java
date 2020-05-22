@Service
public class UserServiceImpl implements UserService {


private SessionFactory sessionFactory;

public UserServiceImpl() {
    sessionFactory = new Configuration().configure().buildSessionFactory();

}


@Override
public Collection<Person> getAllUsers() {
    Collection<Person> peoples = new ArrayList<Person>();
    Session session = sessionFactory.getCurrentSession();
    session.beginTransaction();
    Query query = session.createQuery("from Person").setMaxResults(500);
    peoples.addAll(query.list());
    session.close();
    return peoples;
}
}