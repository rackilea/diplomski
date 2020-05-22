import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertPictureToMySql {
  public static void main(String[] args) throws Exception, IOException, SQLException {
    Class.forName("org.gjt.mm.mysql.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/databaseName", "root", "root");
    String INSERT_PICTURE = "INSERT INTO MyPictures (photo) VALUES (?)";

    FileInputStream fis = null;
    PreparedStatement ps = null;
    try {
      conn.setAutoCommit(false);
      File file = new File("/tmp/photo.png");
      fis = new FileInputStream(file);
      ps = conn.prepareStatement(INSERT_PICTURE);
      ps.setBinaryStream(1, fis, (int) file.length());
      ps.executeUpdate();
      conn.commit();
    } finally {
      ps.close();
      fis.close();
    }
  }
}