import java.io.IOException;
import java.net.URL;
import org.apache.avro.ipc.HttpTransceiver;
import org.apache.avro.ipc.Responder;
import org.apache.avro.ipc.ResponderServlet;
import org.apache.avro.ipc.reflect.ReflectRequestor;
import org.apache.avro.ipc.reflect.ReflectResponder;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.jetty.servlet.ServletHolder;

/**
 *
 * @author bennyl
 */
public class MultiResponderHttpServer {

    private final Context context;
    private final Server server;
    private final int port;

    public MultiResponderHttpServer(int port) {
        this.port = port;
        server = new Server(port);
        context = new Context(server, "/", Context.SESSIONS);
    }

    public void addResponder(String baseUri, Responder responder) throws IOException {
        ResponderServlet servlet = new ResponderServlet(responder);
        ServletHolder holder = new ServletHolder(servlet);
        context.addServlet(holder, baseUri);
    }

    public int getPort() {
        return port;
    }

    public void close() throws Exception {
        server.stop();
    }

    public void start() throws Exception {
        server.start();
    }

    public void join() throws InterruptedException {
        server.join();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        MultiResponderHttpServer server = new MultiResponderHttpServer(8888);
        server.addResponder("/test_a/*", new ReflectResponder(TestProtocol.class,
                (TestProtocol) why -> "a received a message: '" + why + "'"));
        server.addResponder("/test_b/*", new ReflectResponder(TestProtocol.class,
                (TestProtocol) why -> "b received a message: '" + why + "'"));

        server.start();

        HttpTransceiver atrans = new HttpTransceiver(new URL("http://localhost:" + server.getPort() + "/test_a/"));
        HttpTransceiver btrans = new HttpTransceiver(new URL("http://localhost:" + server.getPort() + "/test_b/"));

        System.out.println(ReflectRequestor.getClient(TestProtocol.class, atrans).go("message to a"));
        System.out.println(ReflectRequestor.getClient(TestProtocol.class, btrans).go("message to b"));

        server.close();
        server.join();
    }

    public interface TestProtocol {

        String go(String why);
    }
}