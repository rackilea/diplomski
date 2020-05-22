package proxycheck;


import java.io.IOException;
import java.io.InputStream;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.URL;



public class ConnectionTest 
{
    private static final String PROXY_HOST_URI = "mycompanyproxy.corp.net";
    private static final int    PROXY_PORT = 7283;
    private static final String TEST_URL   = "http://some.remote.service.com/something";

    public static void main(String[] args) 
    throws IOException 
    {
        Authenticator.setDefault(new EdlsAuthenticator());
        HttpURLConnection conn;
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(PROXY_HOST_URI, PROXY_PORT));

        URL httpUrl = new URL(TEST_URL);
        conn = (HttpURLConnection) httpUrl.openConnection(proxy);

        System.out.println(conn.getResponseCode());
        System.out.println(readResponse((InputStream) conn.getContent()));
    }


    public static String readResponse (InputStream in) 
    throws IOException 
    {
        StringBuffer out = new StringBuffer();
        byte[] b = new byte[4096];
        for (int n; (n = in.read(b)) != -1;) 
        {
            out.append(new String(b, 0, n));
        }
        return out.toString();
    }

}




class EdlsAuthenticator extends Authenticator 
{
    protected PasswordAuthentication getPasswordAuthentication() 
    {       
        String username = "ProxyUsername";
        String password = "ProxyPassword";
        return new PasswordAuthentication(username, password.toCharArray());
    }
}