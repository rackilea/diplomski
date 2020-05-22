package one;
import java.io.File;
import java.io.RandomAccessFile;
public class one {

    public static void main(String args[])
    {
     try
     {
      RandomAccessFile rac = new RandomAccessFile(new File("/home/.../src/one/a.txt"), "r");
      rac.seek(0);
      System.out.println(rac.readLine());
      System.out.println(rac.readLine());
      //Puts the pointer back to first position 
      rac.seek(0);
      System.out.println(rac.readLine());
     }
     catch(Exception e)
     {
        e.printStackTrace();
     }
    }
}