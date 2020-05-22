import java.io.StringWriter;
import org.apache.log4j.Logger;
import org.apache.log4j.Level;
import org.apache.log4j.WriterAppender;
import org.apache.log4j.PatternLayout;

public class Log4jTest implements Runnable {

    public static final String CONSOLE_APPENDER = "CONSOLE_APPENDER";
    private static WriterAppender appender = null;
    private static int counter = 1;

    public static synchronized String getNextId() {
        return "Thread_00"+(counter++);
    }

    public void run() {
        String id="UNKNOWN";
        try {
            id = getNextId();
            Logger log = Logger.getLogger(id);
            log.addAppender(appender);
            log.setLevel(Level.DEBUG);
            log.info(id+" log message 1");
            log.removeAppender(CONSOLE_APPENDER);
            log.info(id+" log message 2");
            log.error(id+" log message 3");
        } catch (Exception e) {
            System.out.println("Error in "+id);
            e.printStackTrace();
        }
    }

    public static void main(String [] args) {
        try {
            StringWriter consoleWriter = new StringWriter();
            appender = new WriterAppender(new PatternLayout("%d{ISO8601} %p - %m%n"),consoleWriter);
            appender.setName(CONSOLE_APPENDER);
            appender.setThreshold(org.apache.log4j.Level.DEBUG);

            for (int i=0; i<5; i++) {
                Thread t = new Thread(new Log4jTest());
                t.start();
            }

            Thread.sleep(200);
            System.out.println(consoleWriter.getBuffer().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}