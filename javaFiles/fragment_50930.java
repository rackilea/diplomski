import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Redirector {

    public static void main(String[] args) throws Exception {
        Server server = new Server(1234);
        server.setHandler(new PortRedirector(8080));
        server.start();
        server.dumpStdErr();
        server.join();
    }

    static class PortRedirector extends AbstractHandler {

        int to;

        PortRedirector(int to) {
            this.to = to;
        }

        public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
                throws IOException, ServletException {
            String uri = request.getScheme() + "://" +
                    request.getServerName() +
                    ":" + to +
                    request.getRequestURI() +
                    (request.getQueryString() != null ? "?" + request.getQueryString() : "");
            response.sendRedirect(uri);
        }
    }
}