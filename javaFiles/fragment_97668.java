import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

public class CustomClassLoader extends URLClassLoader {

    public CustomClassLoader(ClassLoader parent) {
        // System classloader will filter inaccessible URLs. 
        // Force null parent to avoid using system classloader.
        super(createURLReferences(), null);
    }

    /**
     * Build an array of URLs based on the java.class.path property.
     * @return An array of urls to search for classes.
     */
    private static URL[] createURLReferences() {
        String classpath = System.getProperty("java.class.path");
        String[] classpathEntries = classpath.split(System.getProperty("path.separator"));
        List<URL> urls = new ArrayList<URL>();
        for (String classpathEntry : classpathEntries) {
            File classpathFile = new File(classpathEntry);
            URI uri = classpathFile.toURI();
            try {
                URL url = uri.toURL();
                urls.add(url);
            } catch (MalformedURLException e) {
                System.out.println("Ignoring classpath entry: " + classpathEntry);
            }
        }

        return urls.toArray(new URL[urls.size()]);
    }
}