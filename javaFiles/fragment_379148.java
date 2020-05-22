import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

...

Session session = sessionFactory.openSession();
Criteria crit = session.createCriteria(Person.class);