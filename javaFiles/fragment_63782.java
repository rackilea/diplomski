import org.apache.log4j.LogManager;
import org.apache.log4j.helpers.FileWatchdog;
import org.apache.log4j.xml.DOMConfigurator;

public class MyXMLWatchdog extends FileWatchdog {
    public MyXMLWatchdog(String filename) {
        super(filename);
    }

    public void doOnChange() {
        new DOMConfigurator().doConfigure(this.filename, LogManager.getLoggerRepository());
        // set your appenders programmatically here
        // ...
    }
}