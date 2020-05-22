import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.http.HTTPConduit;

import javax.net.ssl.KeyManagerFactory;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Optional;

public class CrudeSoapClient {

    private static void initKeyManager(YourSoapServicePort yourSoapServicePort) {
        HTTPConduit httpConduit = (HTTPConduit) ClientProxy.getClient(yourSoapServicePort).getConduit();
        TLSClientParameters tlsClientParameters = Optional.ofNullable(httpConduit.getTlsClientParameters()).orElseGet(TLSClientParameters::new);
        tlsClientParameters.setKeyManagers(getKeyManagerFactory().getKeyManagers());
        httpConduit.setTlsClientParameters(tlsClientParameters);
    }

    public static KeyManagerFactory getKeyManagerFactory() {
        KeyManagerFactory keyManagerFactory = null;
        try (InputStream inputStream = CrudeSoapClient.class.getClassLoader().getResourceAsStream("yourkeystore.pkcs12")) {
            KeyStore ts = KeyStore.getInstance("PKCS12");
            ts.load(inputStream, "yourpassword".toCharArray());
            keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(ts, "yourpassword".toCharArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return keyManagerFactory;
    }
}