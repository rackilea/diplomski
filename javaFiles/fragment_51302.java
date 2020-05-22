import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        String file0 = "/Users/arvind.avinash/file.txt";
        String file1 = "file:///Users/arvind.avinash/file.txt";
        String file2 = "file.txt"; // assuming that the working dir is /Users/arvind.avinash.

        System.out.println(getFile(file0).exists());
        System.out.println(getFile(file1).exists());
        System.out.println(getFile(file2).exists());
    }

    static File getFile(String pathOrUri) {
        URI uri;
        try {
            uri = new URL(pathOrUri).toURI();
        } catch (MalformedURLException | URISyntaxException e) {
            return new File(pathOrUri);
        }
        return new File(uri);
    }
}