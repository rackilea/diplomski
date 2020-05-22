String alias = "Alias to my PK";
char[] pass = "MyPassword".toCharArray();

KeyStore ks = KeyStore.getInstance("Windows-MY");
ks.load(null, pass);
Provider p =  ks.getProvider();

Signature sig = Signature.getInstance("SHA1withRSA",p);
PrivateKey key = (PrivateKey) ks.getKey(alias, pass)

sig.initSign(key);
sig.update("Testing".getBytes());
sig.sign();