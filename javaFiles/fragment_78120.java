public interface Database {
    public ResultSet selectFirstTable(double badgeID);
}

public class MySQLDatabase implements Database {

    public ResultSet selectFirstTable(double badgeID) {
         int i = (int) badgeID;
         // code to select first table in MySQL
    }

}

public class DerbyDatabase implements Database {

    public ResultSet selectFirstTable(double badgeID) {
        String s = Double.toString(badgeID);
        // code to select first table in Derby
    }

}