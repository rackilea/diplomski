import com.sun.nio.file.ExtendedWatchEventModifier;
import org.json.JSONException;

import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class fileStatus {

    public static void main(String[] args) throws IOException, JSONException, InterruptedException {
        try (WatchService svc = FileSystems.getDefault().newWatchService()) {
            final Path path = Paths.get("C:/ADovzhenko/watch_dir");
            registerAll(path, svc);
            WatchKey wk;
            do {
                wk = svc.take();
                for (WatchEvent<?> event : wk.pollEvents()) {
                    WatchEvent.Kind<?> type = event.kind();
                    Path child = path.resolve((Path) event.context());
                    URI uri = child.toUri();
                    System.out.println("Created: " + child);
                }
            } while (wk.reset());
        }
    }

    private static Path registerAll(Path path, final WatchService svc) throws IOException {
        //Register folder and its sub-folders
        path.register(svc, new WatchEvent.Kind<?>[]{StandardWatchEventKinds.ENTRY_CREATE}, ExtendedWatchEventModifier.FILE_TREE);

        //Print all existing directories
        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            public FileVisitResult preVisitDirectory(final Path dir, BasicFileAttributes attrs) throws IOException {
                if (attrs.isDirectory()) {
                    System.out.println("Existing: " + dir);
                    return FileVisitResult.CONTINUE;
                }
                //In case if print of non-directory is required
                //System.out.println("Existing: " + dir);
                return FileVisitResult.SKIP_SIBLINGS;
            }
        });
        return path;
    }

}