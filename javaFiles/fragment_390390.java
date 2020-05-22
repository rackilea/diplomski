import java.io.PrintStream;
import java.lang.management.ManagementFactory;
import java.util.Map;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

import org.slf4j.LoggerFactory;
import org.slf4j.bridge.SLF4JBridgeHandler;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.logback.InstrumentedAppender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableMap;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.jmx.JMXConfigurator;
import ch.qos.logback.classic.jul.LevelChangePropagator;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Appender;
import ch.qos.logback.core.util.StatusPrinter;
import io.dropwizard.logging.AppenderFactory;
import io.dropwizard.logging.LoggingFactory;

public class BetterDropWizardLoggingConfig extends LoggingFactory {

    @JsonIgnore
    final LoggerContext loggerContext;

    @JsonIgnore
    final PrintStream configurationErrorsStream;

    @JsonProperty("loggerMapping")
    private ImmutableMap<String, String> loggerMappings;

    private static void hijackJDKLogging() {
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();
    }

    public BetterDropWizardLoggingConfig() {
        PatternLayout.defaultConverterMap.put("h", HostNameConverter.class.getName());
        this.loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        this.configurationErrorsStream = System.err;
    }

    private Logger configureLevels() {
        final Logger root = loggerContext.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);
        loggerContext.reset();

        final LevelChangePropagator propagator = new LevelChangePropagator();
        propagator.setContext(loggerContext);
        propagator.setResetJUL(true);

        loggerContext.addListener(propagator);

        root.setLevel(getLevel());

        for (Map.Entry<String, Level> entry : getLoggers().entrySet()) {
            loggerContext.getLogger(entry.getKey()).setLevel(entry.getValue());
        }

        return root;
    }

    @Override
    public void configure(MetricRegistry metricRegistry, String name) {
        hijackJDKLogging();

        final Logger root = configureLevels();

        for (AppenderFactory output : getAppenders()) {
            Appender<ILoggingEvent> build = output.build(loggerContext, name, null);
            if(output instanceof MappedLogger && ((MappedLogger) output).getLoggerName() != null) {
                String appenderName = ((MappedLogger) output).getLoggerName();
                String loggerName = loggerMappings.get(appenderName);
                Logger logger = this.loggerContext.getLogger(loggerName);
                logger.addAppender(build);
            } else {
                root.addAppender(build);
            }
        }

        StatusPrinter.setPrintStream(configurationErrorsStream);
        try {
            StatusPrinter.printIfErrorsOccured(loggerContext);
        } finally {
            StatusPrinter.setPrintStream(System.out);
        }

        final MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        try {
            final ObjectName objectName = new ObjectName("io.dropwizard:type=Logging");
            if (!server.isRegistered(objectName)) {
                server.registerMBean(new JMXConfigurator(loggerContext, server, objectName), objectName);
            }
        } catch (MalformedObjectNameException | InstanceAlreadyExistsException | NotCompliantMBeanException
                | MBeanRegistrationException e) {
            throw new RuntimeException(e);
        }

        configureInstrumentation(root, metricRegistry);
    }

    private void configureInstrumentation(Logger root, MetricRegistry metricRegistry) {
        final InstrumentedAppender appender = new InstrumentedAppender(metricRegistry);
        appender.setContext(loggerContext);
        appender.start();
        root.addAppender(appender);
    }

}