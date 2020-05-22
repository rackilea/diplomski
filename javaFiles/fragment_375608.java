package nl.owlstead.so;

import java.nio.charset.StandardCharsets;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.util.Arrays;

public class DecryptGCMWithoutVerification {

    private static final int TAG_SIZE = 128;

    public DecryptGCMWithoutVerification() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) throws Exception {

        // --- encryption using GCM

        Cipher gcm = Cipher.getInstance("AES/GCM/NoPadding");
        SecretKey key = new SecretKeySpec(new byte[16], "AES");
        byte[] ivBytes = new byte[12];
        GCMParameterSpec iv = new GCMParameterSpec(TAG_SIZE, ivBytes);
        gcm.init(Cipher.ENCRYPT_MODE, key, iv);
        byte[] ct = gcm.doFinal("owlstead".getBytes(StandardCharsets.US_ASCII));

        // --- decryption using underlying CTR mode

        Cipher ctr = Cipher.getInstance("AES/CTR/NoPadding");

        // WARNING: this is only correct for a 12 byte IV in GCM mode
        byte[] counter = Arrays.concatenate(ivBytes, new byte[4]);
        inc(counter);
        inc(counter);
        IvParameterSpec ctrIV = new IvParameterSpec(counter);
        ctr.init(Cipher.DECRYPT_MODE, key, ctrIV);

        byte[] pt = ctr.doFinal(ct, 0, ct.length - TAG_SIZE / Byte.SIZE);

        System.out.println(new String(pt, StandardCharsets.US_ASCII));
    }

    private static final byte inc(byte[] counter) {
        for (int i = counter.length - 1; i >= 0; i--) {
            if (++counter[i] != 0) {
                return 0;
            }
        }
        return 1;
    }

}