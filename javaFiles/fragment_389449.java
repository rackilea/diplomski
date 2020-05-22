public class Configuration {
  private DBConfiguration dbConfiguration;

  public Configuration() {
    Properties props = readPropertiesFile();
    dbConfiguration = new DBConfiguration(props);
  }

  public String getConnectionString() {
    return dbConfiguration.getConnectionString();
  }
}