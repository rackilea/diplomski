Base64 encoder = new Base64(64);
String cert_begin = "-----BEGIN CERTIFICATE-----\n";
String end_cert = "-----END CERTIFICATE-----";      
byte[] derCert = x509cert.getEncoded();
String pemCertPre = new String(encoder.encode(derCert));
String pemCert = cert_begin + pemCertPre + end_cert;
return pemCert;