import java.io.*;
import java.net.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class URLClassLoaderTest extends URLClassLoader {

    public URLClassLoaderTest(URL[] arg0) {
        super(arg0);
    }

    public void loadJar(URL urlOfJar) throws IOException, IllegalAccessException, ClassNotFoundException {
        if (getFileExtension(urlOfJar.getFile()).equalsIgnoreCase("jar")) {
            addURL(urlOfJar);
            for(final URL url : getURLs()){
                System.out.println(url.toString());
            }
            final ZipInputStream zis = new ZipInputStream(urlOfJar.openStream());
            ZipEntry ze = zis.getNextEntry();
            while (ze!=null) {
                final String className = getClassCanonicalName(ze);
                if (className != null) {
                    loadClass(getClassCanonicalName(ze));
                }
                ze = zis.getNextEntry();
            }
        }
    }

    private String getFileExtension(final String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    private String getClassCanonicalName(final ZipEntry entry) {
        final String entryName = entry.getName();
        if (getFileExtension(entryName).toLowerCase().endsWith("class")) {
            String s = entryName.substring(0,entryName.length()-6);
            s = s.replaceAll("/", ".");
            System.out.println(s);
            return s;
        } else {
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        URL[] url = {new URL("http://pscode.org/lib/mime.jar")};
        URLClassLoaderTest uclt = new URLClassLoaderTest(url);
        uclt.loadJar(url[0]);
    }
}