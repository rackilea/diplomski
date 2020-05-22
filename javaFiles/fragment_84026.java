public class MessageDigestPasswordEncoder extends BaseDigestPasswordEncoder {
    private final String algorithm;
    private int iterations = 1;

    [...]

    public String encodePassword(String rawPass, Object salt) {
        String saltedPass = mergePasswordAndSalt(rawPass, salt, false);   /* 1 */

        MessageDigest messageDigest = getMessageDigest();

        byte[] digest = messageDigest.digest(Utf8.encode(saltedPass));    /* 2 */

        // "stretch" the encoded value if configured to do so
        for (int i = 1; i < this.iterations; i++) {                       /* 3 */
            digest = messageDigest.digest(digest);
        }

        if (getEncodeHashAsBase64()) {
            return Utf8.decode(Base64.encode(digest));
        } else {
            return new String(Hex.encode(digest));                        /* 4 */
        }
    }

    [...]
}