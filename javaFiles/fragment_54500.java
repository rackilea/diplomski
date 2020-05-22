public static String signRequest(String uri, String secret) throws Exception {
    byte[] r = uri.getBytes("US-ASCII");

    // The keys must have the same block size as your hashing algorithm, in this case
    // 64 bytes right-padded with zeros.
    byte[] k_outer = new byte[64];
    System.arraycopy(secret.getBytes("US-ASCII"), 0, k_outer, 0,
        secret.getBytes("US-ASCII").length);
    byte[] k_inner = new byte[64];
    System.arraycopy(secret.getBytes("US-ASCII"), 0, k_inner, 0, 
        secret.getBytes("US-ASCII").length);

    // You'll create two nested hashes. The inner one is initialized with the
    // key xor 0x36 (byte-wise), the other one with the key xor 0x5c.
    for(int i=0; i<k_outer.length; i++)
        k_outer[i] ^= 0x5c;
    for(int i=0; i<k_inner.length; i++)
        k_inner[i] ^= 0x36;

    // Update inner hash with the key and data you want to sign
    RIPEMD160Digest d_inner = new RIPEMD160Digest();
    d_inner.update(k_inner, 0, k_inner.length);
    d_inner.update(r, 0, r.length);

    // Update outer hash with the key and the inner hash 
    RIPEMD160Digest d_outer = new RIPEMD160Digest();
    d_outer.update(k_outer, 0, k_outer.length);

    byte[] o_inner = new byte[d_inner.getDigestSize()];
    d_inner.doFinal(o_inner, 0);
    d_outer.update(o_inner, 0, o_inner.length);

    // Finally, return the hex-encoded hash
    byte[] o_outer = new byte[d_inner.getDigestSize()];
    d_outer.doFinal(o_outer, 0);

    return new String((new Hex()).encode(o_outer), "US-ASCII");
}