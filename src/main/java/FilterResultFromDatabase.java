import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FilterResultFromDatabase {

    public static void main(String[] args) throws SQLException {
        final Connection connection = HConnectionPool.getConnection();
        Statement stmt;
        try {
            stmt = connection.createStatement();
            final String query = "select answer.code as code from answer\n" +
                    "\t\twhere answer.id in (\n" +
                    "        \tselect question.acceptedAnswerId from question)";
            ResultSet rs = stmt.executeQuery(query);
            long i = 0;
            while (rs.next()) {
                if(rs.getString("code").split("\r\n|\r|\n").length < 6){
                    continue;
                }

                String code = rs.getString("code");
                File input = new File("/Users/lracki/Desktop/diplomski/filtered", "fragment_" + i++ + ".java");

                FileOutputStream out = new FileOutputStream(input);
                out.write(code.getBytes());
                out.close();

            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
