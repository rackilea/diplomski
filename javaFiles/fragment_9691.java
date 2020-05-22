import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.Metadata;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.jdbc.Work;


public class Htest {

    public static void main(String ... args) throws SQLException {
        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        Metadata metadata = new MetadataSources( standardRegistry )
                .addAnnotatedClass(TesEntity.class)
                .buildMetadata();

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder()
                .build();

        //one way to get connection version 5.0.2
        Connection c = sessionFactory.
                getSessionFactoryOptions().getServiceRegistry().
                getService(ConnectionProvider.class).getConnection();

        Session sess = null;
        try {
            sess = sessionFactory.getCurrentSession();
        } catch (org.hibernate.HibernateException he) {
            sess = sessionFactory.openSession();
        }


        //If you are using latest version 5.2.3 you can use this line below
        //Connection c =  ((SessionImpl)sess.getSession()).connection();
        System.out.println(c.getMetaData().getDatabaseProductName());

        //another way to get connection
        sess.doWork(new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {
                //connection accessible here
                System.out.println(connection.getMetaData().getDatabaseProductName());
            }
        });
    }
}