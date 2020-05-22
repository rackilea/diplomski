package com.example.resultsetupdate;

import java.sql.*;

public class BookDB {

    private final String data = 
            "jdbc:odbc:DRIVER={Microsoft Access Driver (*.mdb)};" +
            "DBQ=C:\\Users\\Public\\mdbTest.mdb;";
    private Connection con;
    private Statement stmt;
    ResultSet result;

    BookDB() throws SQLException {
        connect();
    }

    public void connect() throws SQLException {
        this.con = DriverManager.getConnection(data);
        this.stmt = this.con
                .createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
        this.result = this.stmt
                .executeQuery("SELECT BookCode, BookTitle, BookPrice FROM Books");
    }

    public void close() throws SQLException {
        this.con.close();
    }

    public void updateRecord(Book book) throws SQLException {
        result.updateString("BookCode", book.getCode());
        result.updateString("BookTitle", book.getTitle());
        result.updateBigDecimal("BookPrice", book.getPrice());
        result.updateRow();
    }
}