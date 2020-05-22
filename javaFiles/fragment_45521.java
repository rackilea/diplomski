import java.sql.Clob;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.dbutils.BasicRowProcessor;

public class ClobAwareRowProcessor extends BasicRowProcessor {

    @Override
    public Map<String, Object> toMap(ResultSet resultSet) throws SQLException {
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int columnCount = resultSetMetaData.getColumnCount();

        Map<String, Object> map = new HashMap<>();

        for (int index = 1; index <= columnCount; ++index) {
            String columnName = resultSetMetaData.getColumnName(index);
            Object object = resultSet.getObject(index);
            if (object instanceof Clob) {
                object = resultSet.getString(index);
            }

            map.put(columnName, object);
        }

        return map;
    }
}