import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public final class MyFormatter extends Formatter {

    @Override
    public String format(LogRecord record) {
        StringBuilder sb = new StringBuilder();

        // Build output the way you want
        sb.append(new Date(record.getMillis()))
            .append(" \t")
            .append(record.getThreadID())
            .append(" \t")
            .append(record.getSourceMethodName())
            .append(" \t")
            .append(record.getSourceClassName())
            .append(" \t")
            .append(record.getLevel().getLocalizedName())
            .append(": ")
            .append(formatMessage(record))
            .append(System.getProperty("line.separator"));

        return sb.toString();
    }
}