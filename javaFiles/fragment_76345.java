InputStream inStream = new FileInputStream("YOUR_FILE.der");

CertificateFactory cf = CertificateFactory.getInstance("X.509");
X509Certificate cert_x509 = (X509Certificate) cf.generateCertificate(inStream2);
Date validFrom = cert_x509.getNotBefore();
Date validTo = cert_x509.getNotAfter();

inStream.close();