public interface RowMapper<T>{
    public T getRowId(ResultSet rs) throws SQLException;
}

public class ParentRowMapper implements RowMapper<Long>{

    public Long getRowId(ResultSet rs) throws SQLException {
        return rs.getLong(1);
     }
}

public class ChildRowMapper implements RowMapper<String>{

    public String getRowId(ResultSet rs) throws SQLException {
        return rs.getString(1);
     }
}