package domain.app.data.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import domain.app.data.Student;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().build();
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Student.class);
        return configuration.buildSessionFactory(serviceRegistry);
    }

    public static SessionFactory getSession() {
        return sessionFactory;
    }

}