package accesstest;

import java.io.File;
import java.sql.*;

public class AccessTest {

    public static void main(String[] args) {
        // find the folder in which this class currently lives
        //   ref: http://www.roseindia.net/java/java-get-example/get-class-location.shtml
        final java.net.URL classLocationURL;
        final String classLocation = AccessTest.class.getName().replace('.', '/') + ".class";
        final ClassLoader loader = AccessTest.class.getClassLoader();
        classLocationURL = loader.getResource(classLocation);

        File classFile = new File(classLocationURL.toString().substring(6));  // remove "file:/" prefix
        String codePath = classFile.getParent();

        Connection con;
        try {
            con = DriverManager.getConnection(
                    "jdbc:odbc:" +
                    "Driver={Microsoft Access Driver (*.mdb, *.accdb)};" +
                    "Dbq=" + codePath + "\\Database1.accdb;");
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO ContactInfo (FullName, Address, ContactNumber) " +
                    "VALUES (?,?,?)");
            ps.setString(1, "Gord Thompson");
            ps.setString(2, "Canada");
            ps.setString(3, "111-222-3333");
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}