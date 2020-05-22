String password = "xxxxxxxxx";
String storeType = "PKCS11";

String configuration = "name = OpenSC\n"
        + "library = /usr/lib/opensc-pkcs11.so\n";
Provider provider = new sun.security.pkcs11.SunPKCS11(
        new ByteArrayInputStream(configuration.getBytes("UTF-8")));

Security.addProvider(provider);

KeyStore keyStore = KeyStore.getInstance(storeType, provider);
keyStore.load(null, password.toCharArray());