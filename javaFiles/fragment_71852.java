@Mojo(name = "credentials")
public class CredentialsMojo extends AbstractMojo {

  @Parameter(property = "credentials.propertiesDirectory", defaultValue = "empty")
  private String propertiesDirectory;

  @Parameter(property = "credentials.propertiesFileName", defaultValue = "credentials")
  private String propertiesFileName;

  @Parameter(property = "credentials.nameLength", defaultValue = "6")
  private int nameLength;

  @Parameter(property = "credentials.password", defaultValue = "Welkom01@")
  private String password;

  public void execute() throws MojoExecutionException {
    getLog().info("Creating "+ propertiesFileName +".properties");
    parseDirectoryName();

    try (OutputStream output = new FileOutputStream(new File(propertiesDirectory + propertiesFileName +".properties"))) {
      tryCreateCredentialProperties(output);
    } catch (IOException io) {
      getLog().error(io);
    }
  }

  private void parseDirectoryName() {
    if (propertiesDirectory.equals("empty")) propertiesDirectory = "";
    addSlashToDirectory();
  }

  private void addSlashToDirectory() {
    if (propertiesDirectory.equals("") || propertiesDirectory.endsWith("/")) return;
    propertiesDirectory = propertiesDirectory + File.separator;
  }

  private OutputStream tryCreateCredentialProperties(OutputStream output) throws FileNotFoundException, IOException {
    final String username = RandomStringUtils.randomAlphanumeric(nameLength);
    Properties prop = new Properties();
    prop.setProperty("username", username);
    prop.setProperty("password", password);
    prop.store(output, null);
    getLog().info("Username = " + username);
    getLog().info("Password = " + password);
    return output;
  }
}