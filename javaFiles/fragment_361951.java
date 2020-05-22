package com.smart.data.customer;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: dulithdecozta
 * Date: 2/5/15
 * Time: 7:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class CustomerInfoProvider {
    static Logger log = Logger.getLogger(CustomerInfoProvider.class.getName());
    ResultSet customerResultSet = null;
    Connection conn = null;

    public void provideRequiredCustomerDetails(ArrayList customerIdArraylist) {
        for (int i = 0; i < customerIdArraylist.size(); i++) {
            try {
                customerResultSet = findDetails(customerIdArraylist.get(i).toString());
                try {
                    while (customerResultSet.next()) {
                        try {
                            System.out.println("Fullname : " + customerResultSet.getString("fullname"));
                            System.out.println("Consumer ID : " + customerResultSet.getString("customer_id"));
                            System.out.println("City : " + customerResultSet.getString("city"));
                            System.out.println("gender : " + customerResultSet.getString("gender"));
                            System.out.println("Occupation : " + customerResultSet.getString("occupation"));
                            System.out.println(i);
                            System.out.println("*-*-*-*-*-*-*-*-*--*-*-*-*-*-*-*-*");
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public ResultSet findDetails(String consumerId) throws IOException {
        // Load property file
        Properties properties = new Properties();
        // Define an input stream
        InputStream inputStream = null;
        ResultSet rs = null;
        try {
            inputStream = new FileInputStream("/home/abc/Desktop/Jigi/database.properties"); // Path to the property file
        } catch (FileNotFoundException e) {
            log.debug("Exception encountered : File Not Found : ");
            e.printStackTrace();
        }
        try {
            // load a properties file
            properties.load(inputStream);
        } catch (IOException e) {
            log.debug("Exception encountered : A problem with the Input Stream : ");
            e.printStackTrace();
        }
        conn = null;
        Statement stmt = null;
        try {
            Class.forName(properties.getProperty("JDBC_DRIVER"));
            // log.debug("Connecting to database...!!");
            conn = DriverManager.getConnection(properties.getProperty("DB_URL"), properties.getProperty("USER"), properties.getProperty("PASS"));
            //    log.debug("Creating statement...!");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM customer WHERE customer_id=" +consumerId);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return rs;
    }
}