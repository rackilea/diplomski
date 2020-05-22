public abstract class RowMapper<E> {

    public List<E> processResultSet(ResultSet rs) throws SQLException {
         List<E> objectList = new ArrayList<>();

         while(rs.next()) {
            objectList.add(mapRow(rs));
         }

         return objectList;
    }

    abstract E mapRow(ResultSet rs) throws SQLException;
}