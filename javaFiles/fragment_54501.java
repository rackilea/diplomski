public static String signRequest(String uri, String secret) throws Exception {
    byte[] r = uri.getBytes("US-ASCII");
    byte[] k = secret.getBytes("US-ASCII");

    HMac hmac = new HMac(new RIPEMD160Digest());
    hmac.init(new KeyParameter(k));
    hmac.update(r, 0, r.length);

    byte[] out = new byte[hmac.getMacSize()];
    hmac.doFinal(out, 0);

    return new String((new Hex()).encode(out), "US-ASCII");
}