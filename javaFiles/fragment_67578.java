import java.security.*;
import org.apache.http.conn.ssl.*;


try
{
  SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustSelfSignedStrategy() {
    public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException
    {
      return true;
    }
  }).build();

  CloseableHttpClient client =HttpClients.custom().setSSLContext(sslContext).setSSLHostnameVerifier(new NoopHostnameVerifier())
                              .build();
 }
 catch (KeyManagementException | NoSuchAlgorithmException | KeyStoreException e)
 {
   e.printStackTrace();
 }