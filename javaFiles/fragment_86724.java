Provider p = ProviderUtil.loadKalkanProvider();
X509Certificate ca = X509Util.loadX509Certificate("/tmp/ca/root_ca_rsa.cer", p);
X509Certificate nca = X509Util.loadX509Certificate("/tmp/ca/root_nca_rsa.cer", p);
X509Certificate cert = X509Util.loadX509Certificate("/tmp/cert/user.cer", p);
X509CRL crl = X509Util.loadX509CRL("/tmp/ca/rsa.crl", p);
X509CRL rcrl = X509Util.loadX509CRL("/tmp/ca/root_rsa.crl", p);
ArrayList<X509Extension> list = new ArrayList<X509Extension>();
list.add(nca);
list.add(cert);
list.add(crl);
list.add(rcrl);
CollectionCertStoreParameters certStoreParameters = new CollectionCertStoreParameters(list);
CertStore certStore = CertStore.getInstance("Collection", certStoreParameters, p);
CertPathBuilder builder = CertPathBuilder.getInstance("PKIX", p);
// проверка до корневого CA, можно сократить до промежуточного NCA
TrustAnchor anchor = new TrustAnchor(ca, null);
Set<TrustAnchor> anchors = new HashSet<TrustAnchor>();
anchors.add(anchor);
X509CertSelector selector = new X509CertSelector();
// задаем параметры для селектора конечного сертификата или можно указать полное соответствие сертификата
//selector.setSerialNumber(cert.getSerialNumber());
//selector.setIssuer(cert.getIssuerX500Principal());
selector.setCertificate(cert);
PKIXBuilderParameters builderParameters = new PKIXBuilderParameters(anchors, selector);
// если не добавляли список CRL, то надо отключить проверку
//builderParameters.setRevocationEnabled(false);
builderParameters.addCertStore(certStore);
builderParameters.setSigProvider(p.getName());
PKIXCertPathBuilderResult builderResult = (PKIXCertPathBuilderResult) builder.build(builderParameters);
System.out.println(builderResult);
// можем закодировать и сохранить полученный путь в форматах PkiPath/PKCS7/PEM
//builderResult.getCertPath().getEncoded("PkiPath");