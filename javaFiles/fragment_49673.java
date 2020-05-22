public class CreateDB {
    public static final String DRIVER =  "org.apache.derby.jdbc.EmbeddedDriver";
    public static final String JDBC_URL = "jdbc:derby:zadb;create=true";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {        
        Class.forName(DRIVER);
        Connection connection = DriverManager.getConnection(JDBC_URL);
        connection.createStatement().execute("create table channels (channel varchar(20), topic varchar(20),videoclip varchar(20))");
        connection.createStatement().execute("insert into channels values " +
                                        "('oodp', 'creational', 'singleton'), " +
                                        "('oodp', 'creational', 'factory method'), " +
                                        "('oodp', 'creational', 'abstract factory')");
        System.out.println("channels table created and records successfully inserted...");
    }
}