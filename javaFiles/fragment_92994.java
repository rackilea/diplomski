import java.sql.Connection;
import java.sql.DriverManager;
import org.olap4j.OlapConnection;

Class.forName("mondrian.olap4j.MondrianOlap4jDriver");
Connection conn = DriverManager.getConnection(
    "jdbc:mondrian:" + 
    "Jdbc=jdbc:h2:~/test; " +
    "JdbcUser=sa; " +
    "JdbcPassword=; " +
    "Catalog=file:/mondrian/demo/FoodMart.xml; " +
    "JdbcDrivers=org.h2.Driver");
OlapConnection olapConn = conn.unwrap(OlapConnection.class);