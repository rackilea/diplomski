import java.io.InputStream;
import java.net.URL;

import javax.activation.DataSource;
import javax.activation.URLDataSource;

public abstract class ResourceHelper {

    public static URL getURL(String name) {
        return ResourceHelper.class.getResource(name);
    }

    public static InputStream getInputStream(String name) {
        return ResourceHelper.class.getResourceAsStream(name);
    }

    public static DataSource getDataSource(String name) {
        return new URLDataSource(getURL(name));
    }
}