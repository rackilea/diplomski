import org.apache.commons.lang3.StringUtils;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.interceptor.LoggingMessage;

public class KPLogOutInterceptor extends LoggingOutInterceptor {

    @Override
    public boolean isBinaryContent(String contentType) {
        return contentType != null && (BINARY_CONTENT_MEDIA_TYPES.contains(contentType)|| "application/zip".equals(contentType);
    }
}