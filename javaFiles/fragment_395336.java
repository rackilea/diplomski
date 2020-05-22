private static MessageDigest messageDigest;
static {
    try {
        messageDigest = MessageDigest.getInstance("SHA-512");
    } catch (NoSuchAlgorithmException e) {
        throw new RuntimeException("cannot initialize SHA-512 hash function", e);
    }
}