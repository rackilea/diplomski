import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
...

Path dir = FileSystems.getDefault().getPath( filePath );
DirectoryStream<Path> stream = Files.newDirectoryStream( dir, "*.{txt,doc,pdf,ppt}" );
for (Path path : stream) {
    System.out.println( path.getFileName() );
}
stream.close();