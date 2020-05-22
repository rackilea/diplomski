public class Main {
    public static void main(String args[]) {
        // TODO: Should check args length
        Validator validator = new Validator();
        validator.validateArgs(args[0]);
    }
}

public interface Configuration {
    public String getHomeDirectory();
}

public class DefaultConfiguration implements Configuration {
    public String getHomeDirectory() {
        String home = System.getProperty("user.home");
        if (home == null) {
            throw new RuntimeException("User home directory is not set!");
        }
        return home;
    }
}

public class Validator {
  private Configuration configuration;

  public Validator() {
     this(new DefaultConfiguration());
  }

  public Validator(Configuration configuration) {
     this.configuration = configuration;
  }

  // A simple method to check if the file is at home directory
  public void validateArgs(String s) {
    File f = new File(s);
    if (!s.startsWith(configuration.getHomeDirectory()) || !f.exists() || !additionalBusinessLogic())
      throw new RuntimeException("Not under home directory!");
  }

  // Additional business Logic
  private boolean additionalBusinessLogic() {
     // TODO...
     return true;
  }
}

public class ValidatorTest {
  @Test
  public void validateValidArgsTest() {
     final String homeDirectory = ".."; // TODO
     String existingFile = homeDirectory + ".."; // TODO
     new Validator(new Configuration() {
       public String getHomeDirectory() {
          return homeDirectory;
       }
     }).validateArgs(existingFile);
  }

  @Test(expected = RuntimeException.class)
  public void validateInvalidArgsTest() {
     String existingFile = ".."; // TODO
     new Validator(new Configuration() {
       public String getHomeDirectory() {
          return "-INVALID PATH-";
       }
     }).validateArgs(existingFile);
  }
}