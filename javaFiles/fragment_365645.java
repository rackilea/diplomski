Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
String pem=//PEM STRING
X509Certificate cert = null;
StringReader reader = new StringReader(pem);
PEMReader pr = new PEMReader(reader);
cert = (X509Certificate)pr.readObject();
pr.close();