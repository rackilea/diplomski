import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayDeque;
import java.util.logging.ErrorManager;
import java.util.logging.Filter;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.SocketHandler;

public class ReconnectingSocketHandler extends Handler {

    private SocketHandler target;
    private boolean active;
    private final Watcher listener = new Watcher();
    private final ArrayDeque<LogRecord> pending = new ArrayDeque<>(1);

    public ReconnectingSocketHandler() {
        //@todo Read properties from LogManager.
    }

    @Override
    public synchronized void publish(LogRecord record) {
        if (!active) {  //Prevent reentrance.
            active = true;
            try {
                if (record != null && isLoggable(record)) {
                    pending.add(record);
                }

                //Store only the last few records only on error.
                if (pending.size() > 1000) {
                    pending.pollFirst();
                }

                //While we have retries and records.
                for (int r = 0; r < 2 && !pending.isEmpty(); ++r) {
                    if (target == null) {
                        //@todo implement time based backoff.
                        target = new SocketHandler();
                        target.setLevel(super.getLevel());
                        target.setEncoding(super.getEncoding());
                        target.setFilter(super.getFilter());
                        target.setFormatter(super.getFormatter());
                        target.setErrorManager(listener);
                    }

                    //Write the queue to the socket handler.
                    for (LogRecord lr; (lr = pending.poll()) != null;) {
                        target.publish(lr);
                        //On error, close and retry.
                        if (listener.last != null) {
                            pending.addFirst(lr);
                            reportError(null, listener.last,
                                    ErrorManager.WRITE_FAILURE);
                            listener.last = null;
                            target.close();
                            target = null;
                            break;
                        }
                    }
                }
            } catch (IOException ioe) {
                target = null; //Try again later.
                reportError(null, ioe, ErrorManager.WRITE_FAILURE);
            } finally {
                active = false;
            }
        }
    }

    @Override
    public synchronized void flush() {
        publish((LogRecord) null);
        if (target != null) {
            target.flush();
        }
    }

    @Override
    public synchronized void close() {
        super.setLevel(Level.OFF);
        flush();
        if (target != null) {
            target.close();
            target = null;
        }
    }

    @Override
    public synchronized void setLevel(Level newLevel) {
        super.setLevel(newLevel);
        if (target != null) {
            target.setLevel(newLevel);
        }
    }

    @Override
    public synchronized void setFilter(Filter newFilter) {
        super.setFilter(newFilter);
        if (target != null) {
            target.setFilter(newFilter);
        }
    }

    @Override
    public synchronized void setEncoding(String encoding) throws UnsupportedEncodingException {
        super.setEncoding(encoding);
        if (target != null) {
            target.setEncoding(encoding);
        }
    }

    @Override
    public synchronized void setFormatter(Formatter newFormatter) {
        super.setFormatter(newFormatter);
        if (target != null) {
            target.setFormatter(newFormatter);
        }
    }

    private class Watcher extends ErrorManager {

        Exception last;

        Watcher() {
        }

        @Override
        public void error(String msg, Exception ex, int code) {
            last = ex;
        }
    }
}