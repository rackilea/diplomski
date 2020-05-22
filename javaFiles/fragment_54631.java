import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SimpleExample {


    private String name,education;
    private int age;


    public void setName(String name) {
        this.name = name;
    }
    public void setEducation(String education) {
        this.education = education;
    }
    public void setAge(int age) {
        this.age = age;
    }



    public void insert() throws SQLException,Exception{
        Connection con;
        Statement stmt;

            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/person","root","Welcome123"); 
            stmt=con.createStatement();

            String sql="INSERT INTO personalInfo (name,age,education) VALUES ('"+name+"','"+age+"','"+education+"')";
            stmt.executeUpdate(sql);
    }
}