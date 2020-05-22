import java.io.*;

public class StringWriterDemo {

   public static void main(String[] args) {

      String s = "Hello World";

      // create a new writer
      StringWriter sw = new StringWriter();

      // write portions of strings
      sw.write(s, 0, 4);
      sw.write(s, 5, 6);
      // write full string
      sw.write(s);

      // print result by converting to string
      System.out.println("" + sw.toString());


   }
}