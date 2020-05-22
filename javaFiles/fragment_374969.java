public class CarTypeTypeHandler implements TypeHandler<CarType> {

   public void setParameter(PreparedStatement ps, int paramInt, CarType paramType, JdbcType jdbctype)
         throws SQLException {
      ps.setInt(paramInt, paramType.getId());
   }

   @Override
   public CarType getResult(ResultSet rs, String param) throws SQLException {
      return CarType.get(rs.getInt(param));
   }

   @Override
   public CarType getResult(CallableStatement cs, int col) throws SQLException {
      return CarType.get(cs.getInt(col));
   }
}