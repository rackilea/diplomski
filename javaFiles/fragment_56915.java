import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.util.function.Consumer;

public static void main(String[] args) {
    FileSystem fs = FileSystems.getDefault();
    fs.getFileStores().forEach(new Consumer<FileStore>() {
        @Override
        public void accept(FileStore store) {
            try {
                System.out.println(store.getTotalSpace());
                System.out.println(store.getUsableSpace());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    });
}