import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.commons.lang.SerializationUtils;

public class SerializationUtilsTrial {
  public static void main(String[] args) {
    try {
      // File to serialize object to
      String fileName = "testSerialization.ser";

      // New file output stream for the file
      FileOutputStream fos = new FileOutputStream(fileName);

      // Serialize String
      SerializationUtils.serialize("SERIALIZE THIS", fos);
      fos.close();

      // Open FileInputStream to the file
      FileInputStream fis = new FileInputStream(fileName);

      // Deserialize and cast into String
      String ser = (String) SerializationUtils.deserialize(fis);
      System.out.println(ser);
      fis.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}