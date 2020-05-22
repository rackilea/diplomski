import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

  public static void main(String[] args) throws IOException {
    var jmodFile = Path.of(args[0]).toAbsolutePath().normalize();
    System.out.println("Listing entries in JMOD file: " + jmodFile);

    try (var fileSystem = FileSystems.newFileSystem(jmodFile)) {
      Files.walk(fileSystem.getRootDirectories().iterator().next())
          .forEachOrdered(System.out::println);
    }
  }
}