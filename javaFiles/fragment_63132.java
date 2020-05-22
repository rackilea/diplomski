import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.future.IoFutureListener;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.core.future.WriteFuture;
import org.apache.asyncweb.common.HttpRequest;
import org.apache.asyncweb.common.HttpResponseStatus;
import org.apache.asyncweb.common.MutableHttpResponse;
import org.apache.asyncweb.common.DefaultHttpResponse;
import org.apache.asyncweb.common.HttpHeaderConstants;



public class HttpProtocolHandler implements IoHandler {
    private static final int CONTENT_PADDING = 0; // 101

    private final Map<Integer, IoBuffer> buffers = new ConcurrentHashMap<Integer, IoBuffer>();

    private final Timer timer;

    public HttpProtocolHandler() {
        timer = new Timer(true);
    }

    public void exceptionCaught(IoSession session, Throwable cause)
            throws Exception {
        if (!(cause instanceof IOException)) {
            cause.printStackTrace();
        }
        session.close();
    }

    public Dictionary extractParameters(Map hashParameters){
        Dictionary parameters = new Hashtable();
        Iterator it = hashParameters.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            parameters.put(pair.getKey(), ((ArrayList) pair.getValue()).get(0) );
            // it.remove(); // avoids a ConcurrentModificationException
        }

        return parameters;
    }

    public void messageReceived(IoSession session, Object message)
            throws Exception {
        HttpRequest req = (HttpRequest) message;
        String path = req.getRequestUri().getPath(); //path: /echo
        String end_point = path;
        Dictionary parameters = this.extractParameters(req.getParameters());
        String response = "";
        /* switch (end_point) {
            case "/io":
                response= new IOHandler().handleRequest(parameters);
                break;
            case "/cpu":
                response= new CPUHandler().handleRequest(parameters);
                break;
            case "/db":
                response= new DBHandler().handleRequest(parameters);
                break;
            case "/memory":
                response= new MemoryHandler().handleRequest(parameters);
                break;
            default:
                response = "No end point found";
        } */
        response = "No end point found";

        MutableHttpResponse res;


//        if (path.startsWith("/size/")) {
//            doDataResponse(session, req);
//        } else if (path.startsWith("/delay/")) {
//            doAsynchronousDelayedResponse(session, req);
//        } else if (path.startsWith("/adelay/")) {
//            doAsynchronousDelayedResponse(session, req);
//        } else {
        res = new DefaultHttpResponse();



        IoBuffer bb = IoBuffer.allocate(1024);
        bb.setAutoExpand(true);
        bb.putString(response.toString(), Charset.forName("UTF-8").newEncoder());
        bb.flip();
        res.setContent(bb);

//        res.setHeader("Pragma", "no-cache");
//        res.setHeader("Cache-Control", "no-cache");
        res.setStatus(HttpResponseStatus.OK);

        WriteFuture future = session.write(res);
        if (!HttpHeaderConstants.VALUE_KEEP_ALIVE.equalsIgnoreCase(
                res.getHeader( HttpHeaderConstants.KEY_CONNECTION))) {
            future.addListener(IoFutureListener.CLOSE);
        }

    }

    private void writeResponse(IoSession session, HttpRequest req,
            MutableHttpResponse res) {
        res.normalize(req);
        WriteFuture future = session.write(res);
        if (!HttpHeaderConstants.VALUE_KEEP_ALIVE.equalsIgnoreCase(
                res.getHeader( HttpHeaderConstants.KEY_CONNECTION))) {
            future.addListener(IoFutureListener.CLOSE);
        }
    }

    private void doDataResponse(IoSession session, HttpRequest req) {
        String path = req.getRequestUri().getPath();
        int size = Integer.parseInt(path.substring(path.lastIndexOf('/') + 1))
                + CONTENT_PADDING;

        MutableHttpResponse res = new DefaultHttpResponse();
        res.setStatus(HttpResponseStatus.OK);
        res.setHeader("ETag", "W/\"" + size + "-1164091960000\"");
        res.setHeader("Last-Modified", "Tue, 31 Nov 2006 06:52:40 GMT");

        IoBuffer buf = buffers.get(size);
        if (buf == null) {
            buf = IoBuffer.allocate(size);
            buffers.put(size, buf);
        }

        res.setContent(buf.duplicate());
        writeResponse(session, req, res);
    }

    private void doAsynchronousDelayedResponse(final IoSession session,
            final HttpRequest req) {
        String path = req.getRequestUri().getPath();
        int delay = Integer.parseInt(path.substring(path.lastIndexOf('/') + 1));

        final MutableHttpResponse res = new DefaultHttpResponse();
        res.setStatus(HttpResponseStatus.OK);
        res.setHeader("ETag", "W/\"0-1164091960000\"");
        res.setHeader("Last-Modified", "Tue, 31 Nov 2006 06:52:40 GMT");

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                writeResponse(session, req, res);
            }
        }, delay);
    }

    public void messageSent(IoSession session, Object message) throws Exception {
    }

    public void sessionClosed(IoSession session) throws Exception {
    }

    public void sessionCreated(IoSession session) throws Exception {
    }

    public void sessionIdle(IoSession session, IdleStatus status)
            throws Exception {
        session.close();
    }

    public void sessionOpened(IoSession session) throws Exception {
        session.getConfig().setIdleTime(IdleStatus.BOTH_IDLE, 30);
    }
}