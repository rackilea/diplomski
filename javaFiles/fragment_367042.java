X509EncodedKeySpec bobPubKeySpec = new X509EncodedKeySpec(bobEncodedPubKey);
KeyFactory keyFactory = KeyFactory.getInstance("DSA");
PublicKey bobPubKey = keyFactory.generatePublic(bobPubKeySpec);
Signature sig = Signature.getInstance("DSA");
sig.initVerify(bobPubKey);
sig.update(data);
sig.verify(signature);