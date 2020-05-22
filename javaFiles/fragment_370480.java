public class A_Main {

private static Properties properties = new Properties();
public static String UserName = null;
public static String Passwd = null;

......
......
......
public static void main(String[] args) throws IOException {
     try (FileReader reader = new FileReader("D:\\Selenium_Workspace\\SeleniumTEST\\lists.properties"))
   {
         properties.load(reader);
         UserName = properties.getProperty("lists.user");
         Passwd = properties.getProperty("lists.password");
         Configuration_Report conf = new Configuration_Report();
         conf.conf_report(UserName, Passwd);
    } catch (IOException | InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
......
......
......