import java.sql.Connection;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Timer;
import java.util.TimerTask;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

public class ACNNContextListener implements ServletContextListener {
    private int FIFTEEN_MINUTES = 15;

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(new DB(), 0, FIFTEEN_MINUTES * 60 * 1000);
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }

    class DB extends TimerTask {

        public void run() {
            try {
                InitialContext ctx = new InitialContext();
                Context envCtx = (Context) ctx.lookup("java:comp/env");

                DataSource d = (DataSource) envCtx.lookup("jdbc/acnn");
                Connection connection = d.getConnection();
                connection.close();
                System.out.println("Done");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}