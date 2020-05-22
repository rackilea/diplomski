package fcdq.iemt.batch.concilliation.utils;

import java.sql.PreparedStatement;
 import java.sql.SQLException;

 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.jdbc.core.PreparedStatementSetter;
 import org.springframework.stereotype.Component;



 @Component("aPrStatSetter")
 public class RunNoSetter implements PreparedStatementSetter {


public void setValues(PreparedStatement ps) throws SQLException {
    ps.setString(1, "hello");
    ps.setString(2, "Hola");
    ps.setTimestamp(3, aTimestamp);
}
 }