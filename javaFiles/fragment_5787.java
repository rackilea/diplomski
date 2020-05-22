import java.sql.CallableStatement; 
import java.sql.Date; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar; 
import org.apache.ibatis.type.JdbcType; 
import org.apache.ibatis.type.TypeHandler; 
public class CustomDateTypeHandler implements TypeHandler { 
@Override 
public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) 
throws SQLException { 
if (null != parameter) { 
long time = ((XMLGregorianCalendar) parameter).toGregorianCalendar().getTimeInMillis(); 
Date date = new java.sql.Date(time); 
ps.setDate(i, date); 
} 
else { 
ps.setTimestamp(i, null); 
} 
} 
@Override 
public Object getResult(ResultSet rs, String columnName) throws SQLException { 
Date date = rs.getDate(columnName); 
if (null == date) { 
return null; 
} 
XMLGregorianCalendar date2 = null;
GregorianCalendar c = new GregorianCalendar();
c.setTime(date);
try {
date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
} catch (DatatypeConfigurationException e) {
e.printStackTrace();
}
return date2;
} 
@Override 
public Object getResult(CallableStatement cs, int columnIndex) throws SQLException { 
return "";
} 
}