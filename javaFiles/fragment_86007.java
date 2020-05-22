public class Main extends Application {

    public void connect() { // <-- Method declaration
        Connect c = new Connect();
        c.setConnection("foo", "foo", "foo");
        Connection conn = c.getConnection();
        Sql sql = new Sql(conn);
        //-- Some other code that works perfectly without the above--
    }

}