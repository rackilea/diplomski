//CONSTRUCTS THE X509 CERTIFIFATE OBJECT

X509v3CertificateBuilder v3CertGen = new X509v3CertificateBuilder(
issuerName, 
serialNumber, 
startDate, endDate, 
DevCsr.getSubject(), 
DevCsr.getSubjectPublicKeyInfo());