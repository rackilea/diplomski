private static byte[] getHmac(final String data, final byte[] key)
        throws NoSuchAlgorithmException, InvalidKeyException {
    // byte[] Login = login.getBytes(StandardCharsets.US_ASCII);//OK
    final byte[] pwdBytes = data.getBytes(StandardCharsets.US_ASCII);// OK

    // MD5
    final MessageDigest md = MessageDigest.getInstance("md5");
    md.update(pwdBytes);
    final byte[] pwdbytes_md5 = md.digest();// OK

    // HMAC
    final Mac mac = Mac.getInstance("HmacMD5");
    final SecretKey sk = new SecretKeySpec(pwdbytes_md5, mac.getAlgorithm());
    mac.init(sk);
    mac.update(key);

    return mac.doFinal();
}