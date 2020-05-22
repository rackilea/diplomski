package com.example.sqlite_pooled;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.AbstractConnectionCustomizer;

public class OurSQLiteConnectionCustomizer extends AbstractConnectionCustomizer {

    public void onAcquire(Connection c, String pdsIdt) throws SQLException {
        try (Statement st = c.createStatement()) {
            st.execute("ATTACH DATABASE 'C:/__tmp/SQLite/test.sqlite' AS test");
        }
    }

}