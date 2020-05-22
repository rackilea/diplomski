package com.logging;

import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.layout.PatternLayout;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.Writer;

@Plugin(name = "WriterAppender", category = "Core", elementType = "appender", printObject = false)
public class WriterAppender extends AbstractAppender{

    private Writer writer;

    protected WriterAppender(String name, Filter filter, Layout<? extends Serializable> layout, boolean ignoreExceptions, String argOne, String argTwo) {
        super(name, filter, layout, ignoreExceptions);
        writer = new PrintWriter(System.out);//init or retrieve writer resource upon construction
    }

    @Override
    public void append(LogEvent logEvent) {
        try {
            writer.write(logEvent.getMessage().getFormattedMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PluginFactory
    public static WriterAppender createAppender(
            @PluginAttribute("name") String name,
            @PluginElement("Layout") Layout<? extends Serializable> layout,
            @PluginElement("Filter") final Filter filter,
            @PluginAttribute("otherAttribute") String otherAttributeOne,
            @PluginAttribute("otherAttributeTwo") String otherAttributeTwo
    ) {
        if (name == null) {
            LOGGER.error("No name provided for MyCustomAppenderImpl");
            return null;
        }
        if (layout == null) {
            layout = PatternLayout.createDefaultLayout();
        }
        return new WriterAppender(name, filter, layout, true, otherAttributeOne,otherAttributeTwo);
    }
}