package org.apache.catalina.valves;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import javax.servlet.ServletException;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;

public class PreAccessLogValve extends AccessLogValve {
    @Override
    public void invoke(Request request, Response response) throws IOException, ServletException {
        long timeStart = System.currentTimeMillis();
        log(request, response, -timeStart); // negative time indicates "before" request
        getNext().invoke(request, response);
        log(request, response, System.currentTimeMillis() - timeStart); // actual (positive) - "after"
    }

    public void log(Request request, Response response, long time) {
        if (started && getEnabled() && null != logElements && (null == condition || null == request.getRequest().getAttribute(condition))) {
            StringBuffer result = new StringBuffer();
            try {
                Date date = (Date) methodGetDate.invoke(this); 
                for (int i = 0; i < logElements.length; i++) {
                    logElements[i].addElement(result, date, request, response, time);
                }
            } catch (Throwable t) { t.printStackTrace(); }
            log(Thread.currentThread().getName() + (time<0?" > ":" < ") + result.toString());
        }
    }

    private static final Method methodGetDate;
    static {
        Method m = null;
        try {
            m = AccessLogValve.class.getDeclaredMethod("getDate");
            m.setAccessible(true);
        } catch (Throwable t) { t.printStackTrace(); }
        methodGetDate = m;
    }
}