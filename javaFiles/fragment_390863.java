import java.io.IOException;
import java.nio.file.*;

public class Program {
    public static void main(String[] args) {

        FileSystem system = FileSystems.getDefault();
        Path original = system.getPath("C:\\programs\\my.xlsx");
        Path target = system.getPath("C:\\programs\\my2.xlsx");

        try {
            // Throws an exception if the original file is not found.
            Files.copy(original, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            System.out.println("ERROR");
        }
    }
}