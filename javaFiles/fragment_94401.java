// Create a file called DumpPrivateKey.java.  The contents should look like so:
public class DumpPrivateKey {
public static void main(String[] args) throws Exception {
  final String keystoreName = args[0];
    final String keystorePassword = args[1];
    final String alias = args[2];
    java.security.KeyStore ks = java.security.KeyStore.getInstance("jks");
    ks.load(new java.io.FileInputStream(keystoreName), keystorePassword.toCharArray());
    System.out.println("-----BEGIN PRIVATE KEY-----");
    System.out.println(new sun.misc.BASE64Encoder().encode(ks.getKey(alias, keystorePassword.toCharArray()).getEncoded()));
    System.out.println("-----END PRIVATE KEY-----");
  }
}