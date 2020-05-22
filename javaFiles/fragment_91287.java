public boolean verfyRSA(String signature, String data, PublicKey key) throws Exception {

    byte[] sign = Base64.decodeBase64(signature);
    byte[] dat = Base64.decodeBase64(data);

    Signature rsaVerify = Signature.getInstance("SHA1withRSAandMGF1");
    rsaVerify.initVerify(key);
    rsaVerify.update(dat);
    return rsaVerify.verify(sign);
}