import java.net.URL;
import java.io.File;

public class JarURL {

    public static void main(String[] args) throws Exception {
        File f = new File("C:\\the.jar");
        URL jarUrl1 = new URL("jar", "", f.getAbsolutePath() + "!/");
        URL jarUrl2 = f.toURI().toURL();
        System.out.println("jarUrl1: " + jarUrl1);
        System.out.println("jarUrl2: " + jarUrl2);
    }
}