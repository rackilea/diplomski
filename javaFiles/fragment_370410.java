package sub.optimal.logger;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class CustomFormatter extends Formatter {

    private static final String format =  "%1tH:%<tM:%<tS %2$-7s %3$s (%4$s) %5$s%6$s%n";
    private static final Date date = new Date();

    @Override
    public String format(LogRecord record) {
        date.setTime(record.getMillis());
        String source = "";
        if (record.getSourceClassName() != null) {
            source = record.getSourceClassName();
            if (record.getSourceMethodName() != null) {
                source += " " + record.getSourceMethodName();
            }
        }
        String message = formatMessage(record);
        String throwable = "";
        if (record.getThrown() != null) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            pw.println();
            record.getThrown().printStackTrace(pw);
            pw.close();
            throwable = sw.toString();
        }
        return String.format(format,
                date,
                record.getLevel().getName(),
                record.getLoggerName(),
                source,
                message,
                throwable);
    }
}