import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPSClient;
import org.apache.commons.net.io.Util;
import org.apache.commons.net.util.TrustManagerUtils;

public method() throws IOException, GeneralSecurityException{

    File storeFile = new File("path/to/keystore");

    KeyStore keyStore = loadStore("JKS", storeFile, "password");
    X509TrustManager defaultTrustManager = TrustManagerUtils.getDefaultTrustManager(keyStore);

    client = new FTPSClient(properties.getProtocol(), isImpicit);

    client.setTrustManager(defaultTrustManager);
    logOutput = new LogOutputStream(log, Level.INFO);
}

//Helper method from apache: http://commons.apache.org/proper/commons-net/apidocs/index.html?org/apache/commons/net/util/KeyManagerUtils.html
private KeyStore loadStore(String storeType, File storePath, String storePass)
        throws KeyStoreException,  IOException, GeneralSecurityException {
        KeyStore ks = KeyStore.getInstance(storeType);
        FileInputStream stream = null;
        try {
            stream = new FileInputStream(storePath);
            ks.load(stream, storePass.toCharArray());
        } finally {
            Util.closeQuietly(stream);
        }
        return ks;
    }