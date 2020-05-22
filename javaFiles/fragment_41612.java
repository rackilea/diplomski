import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {
 private static SessionFactory sessionAnnotationFactory;

 public static SessionFactory getSessionAnnotationFactory() {
    if (sessionAnnotationFactory == null) {
        sessionAnnotationFactory = buildAnnotationSessionFactory();
    }
    return sessionAnnotationFactory;
 }

 private static SessionFactory buildAnnotationSessionFactory() {
    SessionFactory sessionFactory = null;
    try {

        sessionFactory = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
    } catch (HibernateException e) {
        e.printStackTrace();
    }
    return sessionFactory;
 }
}