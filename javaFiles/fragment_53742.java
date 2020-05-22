import java.sql.*;

public class ListSponsorship {
    static Connection conn;

    public static void main(String[] args) {
        try {
            conn = DriverManager.getConnection(
                    "jdbc:ucanaccess://C:/Users/Public/Database1.accdb;");
            PreparedStatement ps1 = conn.prepareStatement(
                    "SELECT memberID, memberName FROM Members " +
                    "WHERE sponsorID IS NULL ORDER BY memberID");
            ResultSet rs = ps1.executeQuery();
            while (rs.next()) {
                ListSponsoredMembers(rs.getInt("memberID"), rs.getString("memberName"), 0);
            }
            ps1.close();
            conn.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private static void ListSponsoredMembers(Integer memberID, String memberName, Integer recursionLevel) {
        for (Integer i = 0; i < recursionLevel; i++) {
            System.out.print("  ");
        }
        System.out.println(memberName);
        try {
            PreparedStatement ps2 = conn.prepareStatement(
                    "SELECT memberID, memberName FROM Members " +
                    "WHERE sponsorID=? ORDER BY memberID");
            ps2.setInt(1, memberID);
            ResultSet rs = ps2.executeQuery();
            Integer newRecursionLevel = ++recursionLevel;
            while (rs.next()) {
                ListSponsoredMembers(rs.getInt("memberID"), rs.getString("memberName"), newRecursionLevel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}