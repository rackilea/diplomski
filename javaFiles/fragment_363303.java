package playground.test.cxf_soap;

import java.security.KeyPair;
import java.security.cert.Certificate;
import java.util.Calendar;

public class Starter {
    public static void main(String[] args) {

        try {

            boolean enableSSL = true;
            char[] entryPass = "entryPass".toCharArray();
            char[] storePass = "storePass".toCharArray();

            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.YEAR, 100);

            // Server Store and Client cert.
            KeyPair srvKeyPair = BCCertUtils.generateKeyPair(2048, "RSA", "SHA1PRNG");
            Certificate srvPrivCert = BCCertUtils.generateSelfSignedCertificate(srvKeyPair, "CN=Test", "SHA256WithRSA", calendar.getTime());
            byte[] srvStoreBytes = BCCertUtils.storeToPKCS12ByteArray("alias", srvPrivCert, storePass, entryPass, srvKeyPair.getPrivate());
            KeyPair SvrCertKeys = BCCertUtils.loadKeysFromPKCS12ByteArray("alias", srvStoreBytes, storePass, entryPass);
            if (!BCCertUtils.moduliMatch(srvKeyPair.getPublic(), SvrCertKeys.getPrivate())) {
                System.err.println("ARRGL");
                return;
            }
            Certificate clientCert = BCCertUtils.loadCertFromPKCS12ByteArray("alias", srvStoreBytes, storePass, entryPass);
            byte[] clientCertBytes = BCCertUtils.storeToPEMByteArray(clientCert);

            Server server = new Server(443, enableSSL, srvStoreBytes, storePass, entryPass);
            while (!server.isRunning()) {
                Thread.sleep(10);
            }

            Client client = new Client("https://localhost:" + 443 + "/signtest/", enableSSL, clientCertBytes);

            System.out.println("Hello SOAP-Server :)");
            System.out.println("  -> " + client.helloReturn("Stahler"));

            System.out.println("Could you tell me if it is working?");
            System.out.println("  -> " + client.isItWorking());

            System.out.println("Awww finally, thank you server and goodbye.");
            System.out.println("  -> " + client.gbyeReturn("Stahler"));
            System.exit(0);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }  
}