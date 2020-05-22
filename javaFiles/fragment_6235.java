package com.zeddarn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import org.apache.log4j.MDC;

public class MySQLDatabaseConnector {

static ThreadLocal<Connection> connection = new ThreadLocal<Connection>();
private static Logger logger = Logger.getLogger(MySQLDatabaseConnector.class);

public static Connection getDBConnection() {

    //check if a mysql connection already exits. This is to avoid reconnecting 
   if (connection.get() == null) {
        try {
            //loading the mysql driver. This means you also have to add mysql libary. You can add manually or via maven
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            //do something to deal with the error of missing mysql driver e.g notification to the user.
             MDC.put("User", "loggeduser");
            logger.error(e.getMessage());
            MDC.getContext().clear();
        }
        try {

            connection.set(DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root"));

        } catch (SQLException e) {               
            MDC.put("User", "loggeduser");
            logger.error(e.getMessage());
            MDC.getContext().clear();
      }
    }
    return connection.get();
}

public static void main(String args[]) {
      MDC.put("User", "loggeduser");
            logger.error("message from exception.getMessage() method");
            MDC.getContext().clear();
}