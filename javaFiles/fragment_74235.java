import java.io.File;
import java.io.IOException;
import java.util.zip.ZipFile;

public class Main {

  public static void main(String[] args) throws IOException {
    var jmodFile = new File(args[0]).getAbsoluteFile();
    System.out.println("Listing entries in JMOD file: " + jmodFile);

    try (var zipFile = new ZipFile(jmodFile)) {
      for (var entries = zipFile.entries(); entries.hasMoreElements(); ) {
        System.out.println(entries.nextElement());
      }
    }
  }
}