import java.awt.Desktop;
import java.io.File;

public class Test2 {
  public static void main(String[] args) throws Exception {
    File f = new File("c:\\temp\\test.bmp");
    Desktop dt = Desktop.getDesktop();
    dt.open(f);
    System.out.println("Done.");
 }
}