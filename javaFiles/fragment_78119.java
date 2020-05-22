public class DatabaseAdapter {

    private DatabaseType type;

    public DatabaseAdapter(DatabaseType type) {
        this.type = type;
    }

    public ResultSet selectFirstTable(double badgeID) {
        if (type == DatabaseType.Derby) {
            String s = Double.toString(badgeID);
            return derbySelectFirstTable(s);
        } else if (type == DatabaseType.MySQL) {
            int i = (int) badgeID;
            return mysqlSelectFirstTable(i);
        } else {
            return null;
        }
    }

}

public enum DatabaseType {
    MySQL, Derby
}