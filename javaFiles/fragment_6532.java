package consultarcalibredb;

import java.sql.*;


public class ConsultarCalibreDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Connection conn = null;

        int id;
        String title, author, path;
        try  {
            DriverManager.registerDriver(new org.sqlite.JDBC());
            conn = DriverManager.getConnection("jdbc:sqlite:/home/user/folder/file.db");
            String sql = "select id, title, author_sort, path from books where author_sort like '%orwell%'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("id\ttitulo\tautor\tpath");
            while (rs.next()) {
                id = rs.getInt("id");
                title = rs.getString("title");
                author = rs.getString("author_sort");
                path = rs.getString("path");

                System.out.println(id+"\n"+title+
                "\n"+author+"\n"+path);

                System.out.println();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }  
    }
}