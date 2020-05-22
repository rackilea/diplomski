import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/**
 * Creates a JSONARRAY from an java.sql.ResultSet.
 * @author Aries
 *
 */
public class SQL2JSON 
{

    public static JSONArray convert(ResultSet rs) throws SQLException, JSONException
          {
            JSONArray json = new JSONArray();
            ResultSetMetaData rsmd = rs.getMetaData();
            rs.beforeFirst();
            while(rs.next()) {
                  int numColumns = rsmd.getColumnCount();
                  JSONObject obj = new JSONObject();

                  for(int i=1; i<numColumns+1; i++) {

                    String column_name = rsmd.getColumnLabel(i);  //Bugfix , works better than getColumnName() /Aries 

                    switch( rsmd.getColumnType( i ) ) {
                      case java.sql.Types.ARRAY:
                        obj.put(column_name, rs.getArray(column_name));     break;
                      case java.sql.Types.BIGINT:
                        obj.put(column_name, rs.getInt(column_name));       break;
                      case java.sql.Types.BOOLEAN:
                        obj.put(column_name, rs.getBoolean(column_name));   break;
                      case java.sql.Types.BLOB:
                        obj.put(column_name, rs.getBlob(column_name));      break;
                      case java.sql.Types.DOUBLE:
                        obj.put(column_name, rs.getDouble(column_name));    break;
                      case java.sql.Types.FLOAT:
                        obj.put(column_name, rs.getFloat(column_name));     break;
                      case java.sql.Types.INTEGER:
                        obj.put(column_name, rs.getInt(column_name));       break;
                      case java.sql.Types.NVARCHAR:
                        obj.put(column_name, rs.getNString(column_name));   break;
                      case java.sql.Types.VARCHAR:
                        obj.put(column_name, rs.getString(column_name));    break;
                      case java.sql.Types.TINYINT:
                        obj.put(column_name, rs.getInt(column_name));       break;
                      case java.sql.Types.SMALLINT:
                        obj.put(column_name, rs.getInt(column_name));       break;
                      case java.sql.Types.DATE:
                        obj.put(column_name, SQL2JSON.convertDateToString(rs.getDate(column_name)));      break;
                      case java.sql.Types.TIMESTAMP:
                        obj.put(column_name, SQL2JSON.convertDateToString(rs.getTimestamp(column_name))); break;
                      default:
                        obj.put(column_name, rs.getObject(column_name));    break;
                    }
                  }

                  json.put(obj);
                }

            return json;
          }
}