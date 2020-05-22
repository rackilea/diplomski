//nopackage DThompson 2012.08.13b
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class JustBConnectSSL {

    /* (optionally bind and) just make SSL connection, for testing reach and trust
     * uses default providers, truststore (normally JRE/lib/security/[jsse]cacerts), 
     * and keystore (normally none), override with -Djavax.net.ssl.{trust,key}Store* 
     */
    public static void main (String[] args) throws Exception {
        if( args.length < 2 ){ System.out.println ("Usage: tohost port [fromaddr [fromport]]"); return; }
        Socket sock = SSLSocketFactory.getDefault().createSocket();
        if( args.length > 2 )
            sock.bind (new InetSocketAddress (args[2], args.length>3? Integer.parseInt(args[3]): 0));
        sock.connect (new InetSocketAddress (args[0], Integer.parseInt(args[1])));
        System.out.println (sock.getInetAddress().getHostName() + " = " + sock.getInetAddress().getHostAddress());
        ((SSLSocket)sock).startHandshake();
        System.out.println ("connect okay " + ((SSLSocket)sock).getSession().getCipherSuite());
    }
}