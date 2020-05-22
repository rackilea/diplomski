package de.jme.toolbox.logging;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.zip.Deflater;

import org.apache.logging.log4j.core.appender.rolling.DefaultRolloverStrategy;
import org.apache.logging.log4j.core.appender.rolling.RollingFileManager;
import org.apache.logging.log4j.core.appender.rolling.RolloverDescription;
import org.apache.logging.log4j.core.appender.rolling.helper.Action;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginConfiguration;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.helpers.Integers;
import org.apache.logging.log4j.core.lookup.StrSubstitutor;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.status.StatusLogger;

/**
 * Own RolloverStrategy to hook the DefaultRolloverStrategy's rollover events
 *
 * Siehe auch:
 * - https://issues.apache.org/jira/browse/LOG4J2-486
 * - http://apache-logging.6191.n7.nabble.com/log4j2-getting-started-amp-rolling-files-tt8406.html#a42402
 * - http://stackoverflow.com/questions/20819376/log4j2-rollingfile-appender-add-custom-info-at-the-start-of-each-logfile
 *
 * @author Joe Merten
 */
@org.apache.logging.log4j.core.config.plugins.Plugin(name="MyRolloverStrategy", category="Core", printObject=true)
public class MyRolloverStrategy extends DefaultRolloverStrategy {

    protected static final Logger logger = StatusLogger.getLogger();

    // ==============================
    // ↓↓↓ Some stuff copied from ↓↓↓
    // https://svn.apache.org/repos/asf/logging/log4j/log4j2/trunk/log4j-core/src/main/java/org/apache/logging/log4j/core/appender/rolling/DefaultRolloverStrategy.java r1556050
    // Just changed »DefaultRolloverStrategy« to »MyRolloverStrategy«

    private static final int MIN_WINDOW_SIZE = 1;
    private static final int DEFAULT_WINDOW_SIZE = 7;

    @PluginFactory
    public static MyRolloverStrategy createStrategy(
            @PluginAttribute("max") final String max,
            @PluginAttribute("min") final String min,
            @PluginAttribute("fileIndex") final String fileIndex,
            @PluginAttribute("compressionLevel") final String compressionLevelStr,
            @PluginConfiguration final Configuration config) {
        final boolean useMax = fileIndex == null ? true : fileIndex.equalsIgnoreCase("max");
        int minIndex;
        if (min != null) {
            minIndex = Integer.parseInt(min);
            if (minIndex < 1) {
                LOGGER.error("Minimum window size too small. Limited to " + MIN_WINDOW_SIZE);
                minIndex = MIN_WINDOW_SIZE;
            }
        } else {
            minIndex = MIN_WINDOW_SIZE;
        }
        int maxIndex;
        if (max != null) {
            maxIndex = Integer.parseInt(max);
            if (maxIndex < minIndex) {
                maxIndex = minIndex < DEFAULT_WINDOW_SIZE ? DEFAULT_WINDOW_SIZE : minIndex;
                LOGGER.error("Maximum window size must be greater than the minimum windows size. Set to " + maxIndex);
            }
        } else {
            maxIndex = DEFAULT_WINDOW_SIZE;
        }
        final int compressionLevel = Integers.parseInt(compressionLevelStr, Deflater.DEFAULT_COMPRESSION);
        return new MyRolloverStrategy(minIndex, maxIndex, useMax, compressionLevel, config.getStrSubstitutor());
    }
    // ↑↑↑ Some stuff copied from ↑↑↑
    // ==============================

    protected MyRolloverStrategy(int minIndex, int maxIndex, boolean useMax, int compressionLevel, StrSubstitutor subst) {
        super(minIndex, maxIndex, useMax, compressionLevel, subst);
    }

    // Wrapper class only for setting a hook to execute()
    static class MyAction implements Action {
        final Action delegate;
        final String fileName;

        public MyAction(final Action delegate, final String fileName) {
            this.delegate = delegate;
            this.fileName = fileName;
        }

        @Override public void run() {
            delegate.run();
        }

        @Override public boolean execute() throws IOException {
            try {
                BufferedWriter writer = null;
                try {
                    writer = new BufferedWriter(new FileWriter(new File(fileName), true));
                    writer.write("****************************\n");
                    writer.write("*** Bye, bye old logfile ***\n");
                    writer.write("****************************\n");
                } finally {
                    if (writer != null)
                        writer.close();
                }
            } catch (Throwable e) {
                logger.error("Writing to bottom of old logfile \"" + fileName + "\" with", e);
            }

            boolean ret = delegate.execute();

            try {
                BufferedWriter writer = null;
                try {
                    writer = new BufferedWriter(new FileWriter(new File(fileName), true));
                    writer.write("*************************\n");
                    writer.write("*** Hello new logfile ***\n");
                    writer.write("*************************\n");
                } finally {
                    if (writer != null)
                        writer.close();
                }
            } catch (Throwable e) {
                logger.error("Writing to top of new logfile \"" + fileName + "\" with", e);
            }

            return ret;
        }

        @Override public void close() {
            delegate.close();
        }

        @Override public boolean isComplete() {
            return delegate.isComplete();
        }
    }

    // Wrapper class only for setting a hook to getSynchronous().execute()
    static class MyRolloverDescription implements RolloverDescription {
        final RolloverDescription delegate;

        public MyRolloverDescription(final RolloverDescription delegate) {
            this.delegate = delegate;
        }

        @Override public String getActiveFileName() {
            return delegate.getActiveFileName();
        }

        @Override public boolean getAppend() {
            //return delegate.getAppend();
            // As long as we already put some data to the top of the new logfile, subsequent writes should be performed with "append".
            return true;
        }

        // The synchronous action is for renaming, here we want to hook
        @Override public Action getSynchronous() {
            Action delegateAction = delegate.getSynchronous();
            if (delegateAction == null) return null;
            return new MyAction(delegateAction, delegate.getActiveFileName());
        }

        // The asynchronous action is for compressing, we don't need to hook here
        @Override public Action getAsynchronous() {
            return delegate.getAsynchronous();
        }
    }

    public RolloverDescription rollover(final RollingFileManager manager) {
        RolloverDescription ret = super.rollover(manager);
        return new MyRolloverDescription(ret);
    }
}