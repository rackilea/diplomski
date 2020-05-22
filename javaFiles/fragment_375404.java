package com.jesse.zhuang;

import org.apache.logging.log4j.core.Core;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.rewrite.RewritePolicy;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.impl.Log4jLogEvent;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.ObjectMessage;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.logging.log4j.message.ReusableMessage;

@Plugin(name = "MaskSensitiveDataPolicy", category = Core.CATEGORY_NAME, 
        elementType = "rewritePolicy", printObject = true)
public class MaskSensitiveDataPolicy implements RewritePolicy {

    private String[] sensitiveClasses;

    @PluginFactory
    public static MaskSensitiveDataPolicy createPolicy(
            @PluginElement("sensitive") final String[] sensitiveClasses) {
        return new MaskSensitiveDataPolicy(sensitiveClasses);
    }

    private MaskSensitiveDataPolicy(String[] sensitiveClasses) {
        super();
        this.sensitiveClasses = sensitiveClasses;
    }

    @Override
    public LogEvent rewrite(LogEvent event) {
        Message rewritten = rewriteIfSensitive(event.getMessage());
        if (rewritten != event.getMessage()) {
            return new Log4jLogEvent.Builder(event).setMessage(rewritten).build();
        }
        return event;
    }

    private Message rewriteIfSensitive(Message message) {
        // Make sure to switch off garbage-free logging
        // by setting system property `log4j2.enable.threadlocals` to `false`.
        // Otherwise you may get ReusableObjectMessage, ReusableParameterizedMessage
        // or MutableLogEvent messages here which may not be rewritable...
        if (message instanceof ObjectMessage) {
            return rewriteObjectMessage((ObjectMessage) message);
        }
        if (message instanceof ParameterizedMessage) {
            return rewriteParameterizedMessage((ParameterizedMessage) message);
        }
        return message;
    }

    private Message rewriteObjectMessage(ObjectMessage message) {
        if (isSensitive(message.getParameter())) {
            return new ObjectMessage(maskSensitive(message.getParameter()));
        }
        return message;
    }

    private Message rewriteParameterizedMessage(ParameterizedMessage message) {
        Object[] params = message.getParameters();
        boolean changed = rewriteSensitiveParameters(params);
        return changed ? new ParameterizedMessage(message.getFormat(), params) : message;
    }

    private boolean rewriteSensitiveParameters(Object[] params) {
        boolean changed = false;
        for (int i = 0; i < params.length; i++) {
            if (isSensitive(params[i])) {
                params[i] = maskSensitive(params[i]);
                changed = true;
            }
        }
        return changed;
    }

    private boolean isSensitive(Object parameter) {
        return parameter instanceof Customer;
    }

    private Object maskSensitive(Object parameter) {
        Customer result = new Customer();
        result.name = ((Customer) parameter).name;
        result.password = "***";
        return result;
    }
}