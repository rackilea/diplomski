import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.ILoggerFactory;

public class MyMain {

    static {
        ILoggerFactory lf = binder.getLoggerFactory();
        Class lfc = lf.getClass();
        System.out.println(lfc.getResource(lfc.getSimpleName() + ".class"));
    }

    private final static Logger LOG = LoggerFactory.getLogger(MyMain.class);

    public void static main( String args[] ) {
        // do stuff...
    }

}