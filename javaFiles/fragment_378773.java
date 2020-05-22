import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Month;

public class Test {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        try (Connection con = DriverManager.getConnection("jdbc:h2:mem:test")) {
            con.setAutoCommit(true);
            String make = "create table if not exists Test (id bigint identity, value date)";
            try (Statement stmt = con.createStatement()) {
                stmt.execute(make);
            }
            try (Statement stmt = con.createStatement()) {
                System.out.println(">> Remove " + stmt.executeUpdate("delete from test") + " rows");
            }
            LocalDate ld = LocalDate.of(2017, Month.DECEMBER, 25);
            for (int index = 0; index < 100; index++) {
                insert(con, ld);
                ld = ld.plusDays(5);
            }
            try (Statement stmt = con.createStatement()) {
                try (ResultSet rs = stmt.executeQuery("select count(*) from test")) {
                    while (rs.next()) {
                        int count = rs.getInt(1);
                        System.out.println("Found " + count + " rows");
                    }
                }
            }

//          String sql = "select value from test";
//          try (PreparedStatement stmt = con.prepareStatement(sql)) {
//              try (ResultSet rs = stmt.executeQuery()) {
//                  while (rs.next()) {
//                      System.out.println(rs.getObject(1));
//                  }
//              }
//          }

            LocalDate startDate = LocalDate.of(2018, Month.JANUARY, 1);
            LocalDate endDate = startDate.plusMonths(1);
            String sql = "select value from test where value between ? and ?";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setDate(1, java.sql.Date.valueOf(startDate));
                stmt.setDate(2, java.sql.Date.valueOf(endDate));
                System.out.println(startDate);
                System.out.println(endDate);
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        java.sql.Date date = rs.getDate(1);
                        System.out.println(date);
                    }
                }
            }
        }
    }

    public static void insert(Connection con, LocalDate ld) throws SQLException {       
        String sql = "insert into test (value) values (?)";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            java.sql.Date date = java.sql.Date.valueOf(ld);
            stmt.setDate(1, date);
            stmt.executeUpdate();
        }
    }

}