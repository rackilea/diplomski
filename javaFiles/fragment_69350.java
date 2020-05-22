import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MainClass {

    private static String PROPERTIES_FILES_PATHNAME = "file:///Users/ftam/Downloads/test/";// for mac

    public static void main(String args[]) throws Exception {
        Properties p = new Properties();

        List<File> files = getFiles();
        for(File file : files) {
            FileInputStream input = new FileInputStream(file);
            p.load(input);
        }

        String label = (String) p.get("page.label");
        System.out.println(label);
    }

    private static List<File> getFiles() throws IOException, URISyntaxException {
        List<File> filesList = new ArrayList<File>();

        URL[] url = { new URL(PROPERTIES_FILES_PATHNAME) };
        URLClassLoader loader = new URLClassLoader(url);
        URL[] urls = loader.getURLs();

        File fileMetaInf = new File(urls[0].toURI());
        File[] files = fileMetaInf.listFiles();
        for(File file : files) {
            if(!file.isDirectory() && file.getName().endsWith(".properties")) {
                filesList.add(file);
            }
        }

        return filesList;
    }
}