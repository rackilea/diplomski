import org.apache.commons.lang3.StringUtils;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.interceptor.LoggingMessage;

public class KPLogOutInterceptor extends LoggingOutInterceptor {

    @Override
    protected String formatLoggingMessage(LoggingMessage loggingMessage) {

        return removePayload(loggingMessage.toString()); 
    }


    private String removePayload(String str){

        StringBuilder builder = new StringBuilder(str);
        if (str.indexOf("Payload:") + 9 > 8) {
            builder.setLength(builder.indexOf("Payload:") + 8);
            builder.append(" <content skipped>\n");
            builder.append(StringUtils.repeat('-', 25));
        }
        return builder.toString();  
    }
}