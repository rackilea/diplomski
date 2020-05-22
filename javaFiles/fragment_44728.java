public interface DBFactory { // Note: interface, not abstract class
    public DataBase createDB();
}

public class MySQLFactory implements DBFactory {
    public DataBase createDB() {
        return new MySQL();
    }
}

public class SQLServerFactory extends DBFactory{
    public DataBase createDB() {
        return new SQLServer();
    }
}