import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App {

    public static void main(String[] args) throws Exception {
        Path dir = Paths.get("/tmp", "subdir", "subsubdir");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*.txt")) {
            for (Path path : stream) {
                System.out.println(path.getFileName());
            }
        }    
    }
}