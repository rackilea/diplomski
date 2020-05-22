import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import org.apache.commons.io.FilenameUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class App {

    public static void main(String[] args) throws IOException {
        String dirStart = "/home/data/";

        Path root = Paths.get(dirStart);

        Files.walkFileTree(root.toAbsolutePath().normalize(), new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, java.nio.file.attribute.BasicFileAttributes attrs) throws IOException {

                // CHANGE OUTPUT TO NEW FILE
                String print_file = file.getFileName().toString();
                String fileNameWithOutExt = FilenameUtils.removeExtension(print_file);
                System.out.println(fileNameWithOutExt);

                // SOUP PART
                String everything = new String(Files.readAllBytes(file), StandardCharsets.UTF_8);

                Document doc = Jsoup.parse(everything);
                String link = doc.select("block.full_text").text();

                try (PrintStream out = new PrintStream(new FileOutputStream(fileNameWithOutExt + "_output.txt"))) {
                    out.println(link);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return FileVisitResult.CONTINUE;
            }
        });
    }

}