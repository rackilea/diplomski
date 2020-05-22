package cipher;

public final class Cipher {

    public Cipher(Range range, int key) {
        this.range = range;
        this.key = key;
    }

    public final Range range;
    public final int key;

    public String encrypt(String plaintext) {
        return cipher(plaintext, key);
    }

    public String decrypt(String ciphertext) {
        return cipher(ciphertext, -key);
    }

    String cipher(String in, int n) {
        StringBuilder out = new StringBuilder(in.length());
        for (int i = 0; i < in.length(); i++) {
            out.append(range.shift(in.charAt(i), n));
        }
        return out.toString();
    }
}