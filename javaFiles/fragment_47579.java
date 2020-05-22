import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

 public class DownloadFileFromDb {

    public static void main(String[] args) {

    final String host = "jdbc:mysql://localhost/onurDB";
    final String user = "onur";
    final String pass = "onurdb958";
    String SQL = "SELECT PICTURE FROM `PIC_STORE` WHERE `ID`=?"; //Here I mistakenly wrote 'FILANAME' here instead of a 'PICTURE'

    Connection conn = null;
    java.sql.PreparedStatement smt = null;
    InputStream input = null;
    FileOutputStream output = null;
    ResultSet rs = null;

    try {

        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Connecting...");

        conn = DriverManager.getConnection(host, user, pass);
        System.out.println("Connection successful..\nNow creating query...");

        smt = conn.prepareStatement(SQL);
        smt.setString(1, "4");  //in this row we have a png picture
        rs = smt.executeQuery();

        output = new FileOutputStream(new File("/Users/MacbookPro/Downloads/pic.png"));
        System.out.println("Getting file please be patient..");

        while (rs.next()) {

            input = rs.getBinaryStream("FILENAME"); //get it from col name
            int r = 0;

/*
*there I've tried with array but nothing changed..Like this :
* byte[] buffer = new byte[2048];
* int r = 0;
* while((r = input.read(buffer)) != -1){
*        out.write(buffer,0,r);}
*/

            while ((r = input.read()) != -1) {
                output.write(r);

            }
        }
        System.out.println("File writing complete !");

    } catch (ClassNotFoundException e) {
        System.err.println("Class not found!");
        e.printStackTrace();
    } catch (SQLException e) {
        System.err.println("Connection failed!");   
        e.printStackTrace();
    } catch (FileNotFoundException e) {
        System.err.println("File not found!");
        e.printStackTrace();
    } catch (IOException e) {
        System.err.println("File writing error..!");
        e.printStackTrace();
    }finally {
        if(rs != null){
            try {
                input.close();
                output.flush();
                output.close();
                smt.close();
                conn.close();
            } catch (SQLException e) {
                System.err.println("Connot close connecton!");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }

}

}