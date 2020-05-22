import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class SecureRandom {

    public static void main(String[] args) {
        try {
            java.security.SecureRandom secureRandomGenerator = java.security.SecureRandom.getInstance("SHA1PRNG");
            byte[] randomBytes = new byte[128];
            secureRandomGenerator.nextBytes(randomBytes);
            int seedByteCount = 5;
            byte[] seed = secureRandomGenerator.generateSeed(seedByteCount);

            java.security.SecureRandom secureRandom1 = java.security.SecureRandom.getInstance("SHA1PRNG");
            secureRandom1.setSeed(seed);
            java.security.SecureRandom secureRandom2 = java.security.SecureRandom.getInstance("SHA1PRNG");
            secureRandom2.setSeed(seed);
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("CustomAlgorithmNotFoundException" + e);
        }
    }
}