private static void encryptPassword(User user) throws UnsupportedEncodingException
{
    RandomNumberGenerator rng = new SecureRandomNumberGenerator();
    ByteSource byteSource = rng.nextBytes();
    String salt = byteSource.toBase64();
    String hashedPasswordBase64 = new Sha256Hash(user.getPassword(), salt, 1024).toBase64();
    user.setPassword(hashedPasswordBase64);
    user.setSalt(salt);
}