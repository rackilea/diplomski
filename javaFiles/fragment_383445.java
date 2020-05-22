import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

String fileToRead = "MY_PATH"+File.separator+"MY_FILE.properties";
Properties prop = new Properties();
try {
    File propertiesFile = new File(fileToRead);
    prop.load(new FileInputStream(propertiesFile));
    String host = prop.getProperty("host");
    String port = prop.getProperty("port");
    String username = prop.getProperty("username");
    String password = prop.getProperty("password");

    System.out.println(host);
    System.out.println(port);
    System.out.println(username);
    System.out.println(password);
} catch (FileNotFoundException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
}