public class ConnectionFactoryCreator {

   private final String pemName;

   private final SSLContext context;

   public ConnectionFactoryCreator(String pemName, SSLContext context) {
      this.pemName = pemName;
      this.context = context;
   }

   public SSLSocketFactory getSocketFactory() throws Exception {

      InputStream resourceAsStream = getClass().getResourceAsStream(pemName);
  byte[] certAndKey = ByteStreams.toByteArray(resourceAsStream);

  byte[] certBytes = parseDERFromPEM(certAndKey, "-----BEGIN CERTIFICATE-----", "-----END CERTIFICATE-----");
  byte[] keyBytes = parseDERFromPEM(certAndKey, "-----BEGIN PRIVATE KEY-----", "-----END PRIVATE KEY-----");

  X509Certificate cert = generateCertificateFromDER(certBytes);

  PrivateKey key = generatePrivateKeyFromDER(keyBytes);

  KeyStore keystore = KeyStore.getInstance("JKS");
  keystore.load(null);
  keystore.setCertificateEntry("cert-alias", cert);
  keystore.setKeyEntry("key-alias", key, "changeit".toCharArray(), new Certificate[] { cert });

  KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
  kmf.init(keystore, "changeit".toCharArray());

  KeyManager[] km = kmf.getKeyManagers();

  context.init(km, null, null);

  return context.getSocketFactory();
   }

   private byte[] parseDERFromPEM(byte[] pem, String beginDelimiter, String endDelimiter) {
  String data = new String(pem);
  String[] tokens = data.split(beginDelimiter);
  tokens = tokens[1].split(endDelimiter);
  return DatatypeConverter.parseBase64Binary(tokens[0]);
   }

   private PrivateKey generatePrivateKeyFromDER(byte[] keyBytes)
     throws InvalidKeySpecException, NoSuchAlgorithmException {
  PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);

  KeyFactory factory = KeyFactory.getInstance("RSA");

  return factory.generatePrivate(spec);
   }

   private X509Certificate generateCertificateFromDER(byte[] certBytes) throws CertificateException {
  CertificateFactory factory = CertificateFactory.getInstance("X.509");

  return (X509Certificate) factory.generateCertificate(new ByteArrayInputStream(certBytes));
 }