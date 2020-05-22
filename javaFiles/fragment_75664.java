package my.logging;

import java.util.Queue;
import java.util.concurrent.*;
import java.util.logging.ConsoleHandler;
import java.util.logging.LogRecord;

public class BufferingHandler extends ConsoleHandler implements AutoCloseable {

    private final Queue<LogRecord> logRecordsFifo = new ConcurrentLinkedQueue<>();
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    public BufferingHandler(final int delay, final TimeUnit timeUnit) {
        super();
        scheduler.scheduleWithFixedDelay(() -> handleLogs(), delay, delay, timeUnit);
    }

    private void handleLogs() {
        while (!logRecordsFifo.isEmpty()) {
            // sync is required to preserve logs order when flushing
            synchronized (logRecordsFifo) { 
                final LogRecord log = logRecordsFifo.poll();
                if (log != null) super.publish(log);
            }
        }
    }

    @Override
    public void publish(final LogRecord record) {
        if (!isLoggable(record)) return;
        logRecordsFifo.add(record);
    }

    @Override
    public void flush() {
        handleLogs();
        super.flush();
    }

    @Override
    public void close() {
        scheduler.shutdown();
        flush();
        super.close();
    }
}