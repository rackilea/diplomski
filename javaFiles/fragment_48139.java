String p12FilePath = "...";
String passwordCertificate= "...";

KeyStore ks = KeyStore.getInstance("PKCS12");
ks.load( new FileInputStream(p12FilePath),
         passwordCertificate.toCharArray());