import org.apache.log4j.xml.DOMConfigurator;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

public final class LogHelper {

    private final static String LOG4J_XML_FILENAME = "log4j.xml";
    private final static String LOG_APPLI_DIRECTORY = "LOG_APPLI_DIRECTORY";
    private final static String FILENAME = "FILENAME";

    public static void initLogsForCurrentFile(String currentFile, String logDir) {
        Assert.hasLength(currentFile);
        Assert.doesNotContain(currentFile, File.pathSeparator);

        ClassPathResource log4jxml = new ClassPathResource(LOG4J_XML_FILENAME);
        if (!log4jxml.exists()) {
            throw new IllegalArgumentException(
                    "The [log4j.xml] configuration file has not been found on the classpath.");
        }

        // TODO Define variables that could be used inside the log4j
        // configuration file
        System.setProperty(FILENAME, FileUtils.removeExtension(currentFile));
        System.setProperty(LOG_APPLI_DIRECTORY, logDir);

        // Reload the log4j configuration
        try {
            DOMConfigurator.configure(log4jxml.getURL());
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    "A problem occured while loading the log4j configuration.",
                    e);
        }
    }
}