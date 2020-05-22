import java.io.File;
import java.io.FileInputStream;
import java.net.InetAddress;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

import java.security.KeyStore;

import org.java_websocket.server.DefaultSSLWebSocketServerFactory;

public class EventWebSocketSecureServer extends EventWebSocketServer {

    private static EventWebSocketSecureServer instance;

    public static EventWebSocketSecureServer instance() {
        return instance;
    }

    public EventWebSocketSecureServer(int port, InetAddress ip) {
        this(port, null, null, ip);
    }

    public EventWebSocketSecureServer(int port, String keystorepath, String keystorepassword, InetAddress ip) {
        super(port, ip);

        try {
            SSLContext sslContext = SSLContext.getInstance("TLS");
            char ksPassword[] = keystorepassword.toCharArray();
            if (!keystorepath.equals("")) {
                KeyStore ks = KeyStore.getInstance("JKS");
                ks.load(new FileInputStream(new File(keystorepath)), ksPassword);

                KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
                kmf.init(ks, ksPassword);
                TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
                tmf.init(ks);

                sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
            } else {
                sslContext.init(null, null, null);
            }
            this.setWebSocketFactory(new DefaultSSLWebSocketServerFactory(sslContext));
        } catch (Exception e) {
            com.gmt2001.Console.out.println("Secure EventSocketServer failed: " + e);
            e.printStackTrace();
        }
    }
}