InputStream is = /* something that returns contents of cert file */;
// you *can* decode from PEM/base64 first, but you don't need to;
// CertificateFactory-X.509 handles both
CertificateFactory cf = CertificateFactory.getInstance ("X.509");
Certificate cert = cf.generateCertificate (is);
// use cert.getPublicKey() for RSA encrypt or verify