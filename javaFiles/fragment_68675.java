static {
    try {
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
    } catch (Exception e) {
        e.printStackTrace();
    }
}

...

String signed = null;
try {
    java.security.Signature signer = java.security.Signature.getInstance("SHA1withRSA", "BC");
    byte[] data = clearText.getBytes("UTF-8");
    signer.initSign(getPrivateKey());

...