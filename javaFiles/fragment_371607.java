import groovy.sql.*;
import java.sql.*;
sql = Sql.newInstance("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger", "oracle.jdbc.driver.OracleDriver");
sql.call("{? = call TRUNC_TABLE(?)}", [Sql.NUMERIC, "FOO"]) { result ->
    println result;
}