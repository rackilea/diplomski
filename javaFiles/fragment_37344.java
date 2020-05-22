import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class Test {
 public static void main(String[] a) {
   try {
     if (Desktop.isDesktopSupported()) {
       Desktop.getDesktop().open(new File("c:\\a.doc"));
     }
   } catch (IOException ioe) {
     ioe.printStackTrace();
  }
}