@Component
@ConfigurationProperties(prefix="cassandra")
public class CassandraClientNew {

   private String keyspaceApp;

   public void setKeyspaceApp(final String keyspaceApp) {
       this.keyspaceApp = keyspaceApp;
   }
}