import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Optional;
import static java.util.concurrent.TimeUnit.MINUTES;

public class FindRecentFileRecursively {

    public static void main(String[] args) throws IOException {
        // create some dummy directories/files
        Path root = Paths.get("/tmp/foobar");
        for (char c = 'A'; c <= 'C'; c++) {
            Path dir = root.resolve("dir_" + c);
            System.out.println("create sample directory " + dir.toString());
            Files.createDirectories(dir);
            long now = System.currentTimeMillis();
            for (int i = 1; i <= 3; i++) {
                File file = dir.resolve("file" + i).toFile();
                file.createNewFile();
                file.setLastModified(now + MINUTES.toMillis(i));
                printFileInfo(file);
            }
        }

        System.out.println("list the most recent file per directory");
        // find all directories below /tmp/foobar
        Files.find(root, Integer.MAX_VALUE, (path, attrs) -> attrs.isDirectory())
                // for each directory
                .forEach((dir) -> {
                    try {
                        // find all contained files
                        Optional<Path> recentFile = Files.find(dir, 1, 
                                  (path, attrs) -> attrs.isRegularFile())
                                // return the file with the recent last
                                // modification time
                                .max((p1, p2)
                                        -> Long.compare(
                                    p1.toFile().lastModified(),
                                    p2.toFile().lastModified()));
                        // if a file was found
                        if (recentFile.isPresent()) {
                            // print modification time and file name
                            printFileInfo(recentFile.get().toFile());
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace(System.err);
                    }
                });
    }

    private static void printFileInfo(File file) {
        System.out.printf("  mtime: %td.%<tm.%<tY  %<tH:%<tM:%<tS  file: %s%n",
                new Date(file.lastModified()),
                file.getAbsolutePath()
        );
    }
}