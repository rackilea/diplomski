import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class SimpleHttpServer {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8888), 0);
        server.createContext("/foo", new HttpHandler() {
            public void handle(HttpExchange t) throws IOException {
                t.sendResponseHeaders(200, 0);
                OutputStream out = t.getResponseBody();
                out.write("hello world".getBytes());
                out.close();
            }
        });
        server.start();
    }
}