public class CustomSSLSocketFactory extends org.apache.http.conn.ssl.SSLSocketFactory
{
private SSLSocketFactory FACTORY = HttpsURLConnection.getDefaultSSLSocketFactory ();

public CustomSSLSocketFactory ()
    {
    super(null);
    try
        {
        SSLContext context = SSLContext.getInstance ("TLS");
        TrustManager[] tm = new TrustManager[] { new FullX509TrustManager () };
        context.init (null, tm, new SecureRandom ());

        FACTORY = context.getSocketFactory ();
        }
    catch (Exception e)
        {
        e.printStackTrace();
        }
    }

public Socket createSocket() throws IOException
{
    return FACTORY.createSocket();
}

 // TODO: add other methods like createSocket() and getDefaultCipherSuites().
 // Hint: they all just make a call to member FACTORY 
}