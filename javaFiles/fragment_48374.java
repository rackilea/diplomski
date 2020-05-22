create or replace and compile java source named "DirList" as

import java.io.*;
import java.sql.*;

public class ChpDirList {

 public static void getList(String directory)
 throws SQLException {

  Connection conn = DriverManager.getConnection("jdbc:default:connection:");
  String sql = "INSERT INTO NGM_DIR_LIST (file_name, file_length, file_type) values (?,?,?)";

  File path = new File(directory);
  String[] list = path.list();
  String element;

  for (int i = 0; i < list.length; i++) {

   element = list[i];


   String fpath = directory + "/" + list[i];

   File f = new File(fpath);

   long len;

   String ftype;


   if (f.isFile()) {

    len = f.length();
    ftype = "F";

   } else {

    len = 0;
    ftype = "D";
   }

   PreparedStatement pstmt = conn.prepareStatement(sql);
   pstmt.setString(1, element);
   pstmt.setLong(2, len);
   pstmt.setString(3, ftype);

   pstmt.executeUpdate();
   pstmt.close();
  }
 }
}