public final class CassandraAstyanaxConnection {

   ...

   private static class ConnectionHolder {
       public static CassandraAstyanaxConnection connection = new CassandraAstyanaxConnection()
   }

   public static CassandraAstyanaxConnection getInstance() {
        return ConnectionHolder.connection;
   }

   ...
}