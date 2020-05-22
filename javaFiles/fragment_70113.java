import groovy.lang.GroovyClassLoader ;
import groovy.lang.GroovyObject ;

public class Test {
    public static void main( String[] args ) throws Exception {
        GroovyClassLoader loader = new GroovyClassLoader() ;
        GroovyObject o = (GroovyObject)loader.loadClass( "File1" ).newInstance() ;
        o.invokeMethod( "run", new Object[] {} ) ;
        loader.close() ;
    }
}