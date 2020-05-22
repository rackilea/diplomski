import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.params.HttpParams;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Custom SSLSocketFactory to limit connections to specific TLS protocols.
 *
 * @author Juan Heyns
 */
public class CustomSSLSocketFactory extends SSLSocketFactory {

    private final String[] tlsProtocols;

    public CustomSSLSocketFactory(SSLContext sslContext, X509HostnameVerifier hostnameVerifier, String[] tlsProtocols) {
        super(sslContext, hostnameVerifier);
        this.tlsProtocols = tlsProtocols;
    }

    @Override
    public Socket connectSocket(Socket socket, InetSocketAddress remoteAddress, InetSocketAddress localAddress, HttpParams params) throws IOException {
        return prepareSocket(super.connectSocket(socket, remoteAddress, localAddress, params));
    }

    @Override
    public Socket createLayeredSocket(Socket socket, String host, int port, boolean autoClose) throws IOException {
        return prepareSocket(super.createLayeredSocket(socket, host, port, autoClose));
    }

    @Override
    public Socket createSocket(HttpParams params) throws IOException {
        return prepareSocket(super.createSocket(params));
    }

    @Override
    @Deprecated
    public Socket createSocket() throws IOException {
        return prepareSocket(super.createSocket());
    }

    @Override
    @Deprecated
    public Socket createSocket(Socket socket, String host, int port, boolean autoClose) throws IOException {
        return prepareSocket(super.createSocket(socket, host, port, autoClose));
    }

    @Override
    @Deprecated
    public Socket connectSocket(Socket socket, String host, int port, InetAddress localAddress, int localPort, HttpParams params) throws IOException {
        return prepareSocket(super.connectSocket(socket, host, port, localAddress, localPort, params));
    }

    /**
     * Any socket returned from this class will first be configured.
     *
     * @param socket
     * @return
     */
    private Socket prepareSocket(Socket socket) {
        if (socket instanceof SSLSocket) {
            SSLSocket sslSocket = (SSLSocket) socket;
            sslSocket.setEnabledProtocols(tlsProtocols);
        }
        return socket;
    }

}