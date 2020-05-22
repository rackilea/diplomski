import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.FileAppender;
import ch.qos.logback.core.rolling.RollingFileAppender;
import io.dropwizard.logging.AppenderFactory;
import io.dropwizard.logging.FileAppenderFactory;

@JsonTypeName("hostnameFile")
public class HostnameFileAppender extends FileAppenderFactory implements AppenderFactory, MappedLogger {

    private static String uuid = UUID.randomUUID().toString();

    @JsonProperty
    private String name;

    public void setCurrentLogFilename(String currentLogFilename) {
        super.setCurrentLogFilename(substitute(currentLogFilename));
    }

    private String substitute(final String pattern) {
        String substitute = null;

        try {
            substitute = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            System.err.println("Failed to get local hostname:");
            e.printStackTrace(System.err);
            substitute = uuid;
            System.err.println("Using " + substitute + " as fallback.");
        }
        return pattern.replace("${HOSTNAME}", substitute);
    }

    @Override
    public void setArchivedLogFilenamePattern(String archivedLogFilenamePattern) {
        super.setArchivedLogFilenamePattern(substitute(archivedLogFilenamePattern));
    }

    @Override
    public String getLoggerName() {
        return name;
    }
}