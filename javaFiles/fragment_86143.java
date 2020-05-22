import java.io.BufferedInputStream; 
import java.nio.file.*; 
import java.util.HashMap; 
import java.util.Map;

public class ReadEntry {

    public static void main(String... args) throws Exception {
        Path zipfile = Path.get("c:/zips/zip1.zip");
        Map<String, String> env = new HashMap();
        FileSystem manager = FileSystems.newFileSystem(zipfile, env,null);
        Path path = manager.getPath("/jarCompress1.jar/META-INF/MANIFEST.MF");
        System.out.println("Reading input stream");
        BufferedInputStream bis = new BufferedInputStream(path.newInputStream());
        int ch = -1;
        while ((ch = bis.read()) != -1) {
            System.out.print((char) ch);
        }
    } 
}