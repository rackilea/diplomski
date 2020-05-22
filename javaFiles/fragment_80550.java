public class GenerateStrongAESKey {

    public static SecretKey generateStrongAESKey(final int keysize) {
        final KeyGenerator kgen;
        try {
            kgen = KeyGenerator.getInstance("AES");
        } catch (final NoSuchAlgorithmException e) {
            throw new RuntimeException("AES key generator should always be available in a Java runtime", e);
        }
        final SecureRandom rng;
        try {
            rng = SecureRandom.getInstanceStrong();
        } catch (final NoSuchAlgorithmException e) {
            throw new RuntimeException("No strong secure random available to generate strong AES key", e);
        }
        // already throws IllegalParameterException for wrong key sizes
        kgen.init(keysize, rng);

        return kgen.generateKey();
    }

    public static void main(String[] args) {
        SecretKey strongAESKey = generateStrongAESKey(256);
        // well, if you must have a human readable string, here it is
        // but you've been warned
        System.out.println(toHex(strongAESKey.getEncoded()));
    }

    private static String toHex(final byte[] data) {
        final StringBuilder sb = new StringBuilder(data.length * 2);
        for (byte b : data) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();
    }
}