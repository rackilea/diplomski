private String sha1(String s, String keyString) throws   UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {

    SecretKeySpec key = new SecretKeySpec((keyString).getBytes("UTF-8"), "HmacSHA1");
    Mac mac = Mac.getInstance("HmacSHA1");
    mac.init(key);

    byte[] bytes = mac.doFinal(s.getBytes("UTF-8"));

    return new String( Base64.encodeBase64(bytes));

    }