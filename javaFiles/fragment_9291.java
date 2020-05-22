Security.addProvider(new BouncyCastleProvider());
// explicit BC factory required, knows about curve!
CertificateFactory fact = CertificateFactory.getInstance("X509", BouncyCastleProvider.PROVIDER_NAME); 
PemReader reader = new PemReader(new FileReader("ecc_certificate.txt"));
PemObject readPemObject = reader.readPemObject();
final byte[] cert = readPemObject.getContent();
Certificate generatedCertificate = fact.generateCertificate(new ByteArrayInputStream(cert));
System.out.println(generatedCertificate);