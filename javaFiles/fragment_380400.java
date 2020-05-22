public class MyUtil {
        private static Connection conn = null;
        private static String url = "jdbc:mysql://localhost:3306/mysql";
        public static Connection getConnection()  {
                try { 
                    Class.forName("com.mysql.jdbc.Driver"); 
                    conn = DriverManager.getConnection(url, "root", "*****");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            return conn;
        }