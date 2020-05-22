String providerName = "SunJSSE";
KeyStore ks = ks = KeyStore.getInstance("pkcs12", providerName);
ks.load(new FileInputStream("/home/test/.cert.pfx", "xxxxxx".toCharArray());
String alias = ks.aliases().nextElement();
PrivateKey pk = (PrivateKey) ks.getKey(alias, pts.getRandom());
Certificate[] chain = ks.getCertificateChain(alias);