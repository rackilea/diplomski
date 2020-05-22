X509Certificate myCert = ...

KeyStore ks = ...

Certificate [] certArray = { myCert };

ks.setKeyEntry(alias, key, certArray);