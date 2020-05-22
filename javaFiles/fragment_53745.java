import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class Snippet {
    public static void main(String[] args) throws IOException, InterruptedException {

        Path pathToWatch = FileSystems.getDefault().getPath("C:\\tmp\\test");
        try (WatchService watchService = pathToWatch.getFileSystem().newWatchService()) {
            Path dir = Paths.get("C:\\tmp\\test");
            dir.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE);
            WatchKey key = watchService.take();
            do {
                for (final WatchEvent<?> event : key.pollEvents()) {
                    Path name = (Path) event.context();
                    File filename = dir.resolve(name).toFile();
                    System.out.println(dir + ": " + event.kind() + ": " + event.context() + ", Modified: " + filename.lastModified());
                }
            } while (key.reset());
        }
    }
}