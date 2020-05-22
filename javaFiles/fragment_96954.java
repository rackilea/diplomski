package myapp.drivers;
public class DriverSource {
    public static InputStream getDriverSource( String identifier ) {
        return this.getClass().getClassLoader().getResourceAsStream(
           this.getClass().getPackage().getName().replace('.', '/')
           + '/' + identifier + '.source'
        );
    }
}