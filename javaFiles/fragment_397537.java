import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class Sandbox {
  public static void main(String[] args) {
    try {
      // convert object to bytes
      Date d1 = new Date();
      System.out.println(d1);
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      ObjectOutputStream oos = new ObjectOutputStream(baos);
      oos.writeObject(d1);
      byte[] buf = baos.toByteArray();

      // convert back from bytes to object
      ObjectInputStream ois =
        new ObjectInputStream(new ByteArrayInputStream(buf));
      Date d2 = (Date) ois.readObject();
      ois.close();

      System.out.println(d2);
    } catch (IOException ioe) {
      ioe.printStackTrace();
    } catch (ClassNotFoundException cnfe) {
      cnfe.printStackTrace();
    }
  }
}