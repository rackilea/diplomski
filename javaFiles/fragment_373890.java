public class ItemPreparedStatementCreatorFactory{
   public PreparedStatementCreator createFor(Item item){
     return new PreparedStatementCreator() {
        @Override
         public PreparedStatement createPreparedStatement(Connection connection) {
           final PreparedStatement ps = connection.prepareStatement( "SET NAME = ? where ID = ?");
           ps.setString(1, item.getName());
           ps.setInt(1, item.getId());
           return ps;
         }
       })
    }
}