import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;


public class CountingFileHandler extends FileHandler {

    private static final RuntimeException PREVENT_ROTATE = new RuntimeException();
    private final long maxRecords;
    private long count;

    public CountingFileHandler(String pattern, long maxRecords, int files) throws IOException {
        super(pattern, 1, files, false);
        this.maxRecords = maxRecords;
    }

    @Override
    public synchronized void setLevel(Level lvl) {
        if (Level.OFF.equals(lvl)) { //Rotation sets the level to OFF.
            if (++count < maxRecords) {
                throw PREVENT_ROTATE;
            }
            count = 0L;
        }
        super.setLevel(lvl);
    }

    @Override
    public synchronized void publish(LogRecord record) {
        try {
            super.publish(record);
        } catch (RuntimeException re) {
            if (re != PREVENT_ROTATE) {
                throw re;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new File(".").getCanonicalPath());
        CountingFileHandler cfh = new CountingFileHandler("test%g.log", 2, 5);
        cfh.setFormatter(new SimpleFormatter());
        for (int i = 0; i < 10; i++) {
            cfh.publish(new LogRecord(Level.SEVERE, Integer.toString(i)));
        }
        cfh.close();
    }
}