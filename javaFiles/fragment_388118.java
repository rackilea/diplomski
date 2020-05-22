import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

public static byte[] encrypt(final byte[] data, final char[] password,
    final byte[] salt, final int noIterations) {
  try {
    final String method = "PBEWITHHMACSHA512ANDAES_256";
    final SecretKeyFactory kf = SecretKeyFactory.getInstance(method);
    final PBEKeySpec keySpec = new PBEKeySpec(password);
    final SecretKey key = kf.generateSecret(keySpec);
    final Cipher ciph = Cipher.getInstance(method);
    final PBEParameterSpec params = new PBEParameterSpec(salt, noIterations);
    return ciph.doFinal(data);
  } catch (final Exception e) {
    // best not to let the encryption error bubble out
    throw new RuntimeException("Spurious encryption error");
  }
}