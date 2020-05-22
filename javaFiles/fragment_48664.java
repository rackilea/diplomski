import org.apache.commons.io.IOUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ResponsePayloadInterceptor extends AbstractPhaseInterceptor<Message> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ResponsePayloadInterceptor.class);

    public ResponsePayloadInterceptor() {
        super(Phase.PRE_STREAM);
    }

    @Override
    public void handleMessage(Message message) throws Fault {
        LOGGER.info("handleMessage() - Response intercepted");
        try {
            OutputStream outputStream = message.getContent(OutputStream.class);
            CachedOutputStream cachedOutputStream = new CachedOutputStream();
            message.setContent(OutputStream.class, cachedOutputStream);

            message.getInterceptorChain().doIntercept(message);

            cachedOutputStream.flush();
            cachedOutputStream.close();

            CachedOutputStream newCachedOutputStream = (CachedOutputStream) message.getContent(OutputStream.class);
            String currentResponse = IOUtils.toString(newCachedOutputStream.getInputStream(), "UTF-8");
            newCachedOutputStream.flush();
            newCachedOutputStream.close();

            if (currentResponse != null) {
                LOGGER.info("handleMessage() - Response: {}", currentResponse);
                LOGGER.info("handleMessage() - Response Length: {}", currentResponse.length());

                if (currentResponse.length() > 500) {
                    InputStream replaceInputStream = IOUtils.toInputStream("{\"message\":\"Too much data\"}", "UTF-8");

                    IOUtils.copy(replaceInputStream, outputStream);
                    replaceInputStream.close();

                    message.setContent(OutputStream.class, outputStream);
                    outputStream.flush();
                    outputStream.close();
                } else {
                    InputStream replaceInputStream = IOUtils.toInputStream(currentResponse, "UTF-8");

                    IOUtils.copy(replaceInputStream, outputStream);
                    replaceInputStream.close();

                    message.setContent(OutputStream.class, outputStream);
                    outputStream.flush();
                    outputStream.close();
                }
            }
        } catch (IOException e) {
            LOGGER.error("handleMessage() - Error", e);
            throw new RuntimeException(e);
        }
    }