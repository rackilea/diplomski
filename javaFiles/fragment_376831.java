public class AddCon {
    private Connection conn;

...

// constructor
public AddCon() {
    try{
        //Load database driver and connect
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(<your parameters>);
        ^----------- MISTAKE
...