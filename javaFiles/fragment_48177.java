X509CertSelector targetConstraints = new X509CertSelector();

targetConstraints.setCertificate(certificates.get(0));
// Here's the issue for PKCS7 certificates since they are not ordered,
// but I havent figured out how I can see what the target certificate
// (lowest level) is in the incoming certificates..

PKIXBuilderParameters params = new PKIXBuilderParameters(anchors, targetConstraints);