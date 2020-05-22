import java.nio.file.*;
    import static java.nio.file.StandardWatchEventKinds.*;
    import java.io.*;

    public class FileWatcher {

        private final WatchService watcher;
        private final Path dir;

        /**
         * Creates a FileWatcher and registers the given directory to be watched
         */
        FileWatcher(Path dir) throws IOException {
            this.watcher = FileSystems.getDefault().newWatchService();
            dir.register(watcher, ENTRY_MODIFY);
            dir.register(watcher, ENTRY_CREATE);
            dir.register(watcher, ENTRY_DELETE);
            System.out.printf("Watching the directory...%s%n", dir);
            this.dir = dir;
        }

        /**
         * Process all events for the key queued to the watcher
         */
        public void processEvents() {
            while(true) {

                // wait for key to be signaled
                WatchKey key;
                try {
                    key = watcher.take();
                } catch (InterruptedException x) {
                    return;
                }

                for (WatchEvent<?> event: key.pollEvents()) {
                    WatchEvent.Kind kind = event.kind();

                    if (kind == OVERFLOW) {
                        continue;
                    }

                    //The filename is the context of the event.
                    WatchEvent<Path> ev = (WatchEvent<Path>)event;
                    Path filename = ev.context();

                    System.out.format("The file %s has been %s%n", filename, kind);
                    //more processing here...
                }

                //Reset the key -- this step is critical if you want to receive
                //further watch events. If the key is no longer valid, the directory
                //is inaccessible so exit the loop.
                boolean valid = key.reset();
                if (!valid) {
                    break;
                }
            }
        }


        public static void main(String[] args) throws IOException {
            //register directory and process its events
            Path dir = Paths.get(args[0]);
            new FileWatcher(dir).processEvents();
        }
    }