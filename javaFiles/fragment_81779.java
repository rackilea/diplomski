package myPackage;
import java.util.Date;

public class Foo {
   public static void main(String args[]) {

      // You create a new date object and assign it to the sysdate
      Date sysdate = new Date();

      // You are now displaying your time and date using toString()
      System.out.println(sysdate.toString());
   }
}