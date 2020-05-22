public class A_Main {

private static Properties properties = new Properties();

public static String UserName = null;
public static String Passwd = null;

static{
     try (FileReader reader = new FileReader("D:\\Selenium_Workspace\\SeleniumTEST\\lists.properties"))
     {
         properties.load(reader);
         UserName = properties.getProperty("lists.user");
         Passwd = properties.getProperty("lists.password");
     } catch (IOException e) {
         e.printStackTrace();
     }

}
......
......
......
public static void main(String[] args) throws IOException {

    Configuration_Report conf = new Configuration_Report();
    try {
        conf.conf_report(UserName, Passwd);
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
......
......
......