public class EncryptionMain {

    public static void main(String args[]){
        System.out.println(encrypt("Hello"));
    }

    static String encrypt(String plaintext) {
        StringBuilder ciphertext = new StringBuilder(plaintext);
        for (int i = 0; i < ciphertext.length(); i++) {
            ciphertext.setCharAt(i, encrypt(ciphertext.charAt(i)));
        }
        return ciphertext.toString();
    }

    static char encrypt(char c) {
        int switchInc = 1; // 0 = BACK 1 = FORWARD

        for(int e = 0; e < 1000; e++){
            if (c == '!') {
                switchInc = 1;
            } else if (c == '~') {
                switchInc = 0;
            }

            switch (switchInc) {
                case 0: c--; break;
                default: c++; break;
            }
        }
        return c;
    }
}