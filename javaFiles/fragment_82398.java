import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

@MappedJdbcTypes({ JdbcType.ARRAY })
@MappedTypes({ Object.class })
public class ListArrayTypeHandler extends BaseTypeHandler<List<?>> {

  @Override
  public void setNonNullParameter(PreparedStatement ps, int i,
      List<?> parameter, JdbcType jdbcType) throws SQLException {
    //  JDBC type is required
    Array array = ps.getConnection().createArrayOf("TEXT", parameter.toArray());
    try {
      ps.setArray(i, array);
    } finally {
      array.free();
    }
  }

  @Override
  public List<?> getNullableResult(ResultSet rs, String columnName) throws SQLException {
    return extractArray(rs.getArray(columnName));
  }

  @Override
  public List<?> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
    return extractArray(rs.getArray(columnIndex));
  }

  @Override
  public List<?> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
    return extractArray(cs.getArray(columnIndex));
  }

  protected List<?> extractArray(Array array) throws SQLException {
    if (array == null) {
      return null;
    }
    Object javaArray = array.getArray();
    array.free();
    return new ArrayList<>(Arrays.asList((Object[])javaArray));
  }
}