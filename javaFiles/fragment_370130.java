X509Certificate certToVerify = ...

CertificateFactory cf = CertificateFactory.getInstance("X.509");
CertPath cp = cf.generateCertPath(Arrays
    .asList(new X509Certificate[] { certToVerify }));

TrustAnchor trustAnchor = new TrustAnchor(caCert, null);

CertPathValidator cpv = CertPathValidator.getInstance("PKIX");
PKIXParameters pkixParams = new PKIXParameters(
    Collections.singleton(trustAnchor));
pkixParams.setRevocationEnabled(false);

cpv.validate(cp, pkixParams);