package com.test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

public class DaoTest {

    @SuppressWarnings("serial")
    public static class DAOException extends Exception {
    }

    public static class Product {

        private final Integer number;
        private String type;
        private String manufacturer;
        private String productionDate;
        private String expiryDate;

        public Product(Integer number) {
            this.number = number;
        }

        public Integer getNumber() {
            return number;
        }

        public String getType() {
            return type;
        }

        public String getManufacturer() {
            return manufacturer;
        }

        public String getProductionDate() {
            return productionDate;
        }

        public String getExpiryDate() {
            return expiryDate;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
        }

        public void setProductionDate(String productionDate) {
            this.productionDate = productionDate;
        }

        public void setExpiryDate(String expiryDate) {
            this.expiryDate = expiryDate;
        }
    }

    public static class Dao {

        private DataSource ds;

        public Dao(DataSource ds) {
            this.ds = ds;
        }

        public void insertProduct(Product p) throws SQLException {
            Connection conn = ds.getConnection();
            PreparedStatement psmt =
                    conn.prepareStatement("SELECT * FROM foo WHERE a = ? AND b = ? AND c = ? AND d = ? AND e = ?");
            psmt.setInt(1, p.getNumber());
            psmt.setString(2, p.getType());
            psmt.setString(3, p.getManufacturer());
            psmt.setString(4, p.getProductionDate());
            psmt.setString(5, p.getExpiryDate());

            // other code here to execute the psmt etc.....
        }
    }

    private DataSource ds = Mockito.mock(DataSource.class);
    private Connection conn = Mockito.mock(Connection.class);
    private PreparedStatement psmt = Mockito.mock(PreparedStatement.class);
    private Dao testingDAO = new Dao(ds);

    @Test
    public void HappyTest2() throws SQLException, DAOException {
        when(ds.getConnection()).thenReturn(conn);
        when(conn.prepareStatement(anyString())).thenReturn(psmt);
        ArgumentCaptor<Integer> integerCaptor = ArgumentCaptor.forClass(Integer.class);
        ArgumentCaptor<String> stringCaptor = ArgumentCaptor.forClass(String.class);

        Product p = new Product(1);
        p.setType("myType");
        p.setManufacturer("myManufacturer");
        p.setProductionDate("myProductionDate");
        p.setExpiryDate("myExpiryDate");

        testingDAO.insertProduct(p);

        verify(psmt, times(1)).setInt(anyInt(), integerCaptor.capture());
        assertTrue(integerCaptor.getAllValues().get(0).equals(1));

        verify(psmt, times(4)).setString(anyInt(), stringCaptor.capture());

        // 0 based index
        assertTrue(stringCaptor.getAllValues().get(0).equals("myType"));
        assertTrue(stringCaptor.getAllValues().get(1).equals("myManufacturer"));
        assertTrue(stringCaptor.getAllValues().get(2).equals("myProductionDate"));
        assertTrue(stringCaptor.getAllValues().get(3).equals("myExpiryDate"));
    }
}