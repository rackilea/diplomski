package helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class Test extends Thread {
  String a1 = "", b1 = "";

  public Test(String a, String b) {
    a1 = a;
    b1 = b;
  }

  Integer resource = new Integer(1);
  public void run() {
    try {
      /*
       * Class.forName("com.mysql.jdbc.Driver"); 
       * Connection con = DriverManager.getConnection(
       * "jdbc:mysql://localhost:3306/EmployeeDetails", "root", "root");
       * PreparedStatement stmt = con.prepareStatement("insert into EmployeeDetail values(?,?,?)");
       * stmt.setString(1, a1); 
       * stmt.setString(2, b1); 
       * stmt.setString(3,Thread.currentThread().getName()); stmt.execute(); con.close();
       */
      synchronized (resource) {
        System.out.println(a1+" # "+b1 +" # "+Thread.currentThread().getName());
      }


    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public static void main(String args[]) throws InterruptedException {
    List<String> fname = new ArrayList<String>();
    fname.add("Vinoth");
    fname.add("Sesha");
    fname.add("Sachin");
    fname.add("Dinesh");
    fname.add("Karan");
    List<String> lname = new ArrayList<String>();
    lname.add("Kumar");
    lname.add("Janarthan");
    lname.add("Sabarish");
    lname.add("Kumar");
    lname.add("Kumar");
    Test obj;
    for (int i = 0; i < 5; i++) {
      obj = new Test(fname.get(i), lname.get(i));
      obj.start();
      obj.join();
      // try{
      // obj.join();
      // }catch(Exception e){System.out.println(e);}
    }
  }
}