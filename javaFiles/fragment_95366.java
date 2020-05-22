// sign
Signature instance = Signature.getInstance("SHA256withRSA");
instance.initSign(privateKey, new SecureRandom());
instance.update(myData.getBytes("UTF-8")); // encoding is important
byte[] signature = instance.sign();

// verify
instance.initVerify(publicKey);
instance.update(myData.getBytes("UTF-8")); // encoding is important
System.out.println(instance.verify(signature));