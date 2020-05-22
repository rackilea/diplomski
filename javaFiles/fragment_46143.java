public class CCipher {

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    //private final String shiftedEncryptAlphabet;
    //private final String shiftedDecryptAlphabet;
    private final int mainKey;

    public CCipher(int key) {
        mainKey = key;
        shiftedAlphabet = ALPHABET.substring(mainKey) 
                        + ALPHABET.substring(0, mainKey);
    }

    public String encrypt(String input){
        String shiftedAlphabet = alphabet.substring(mainKey) 
                    + alphabet.substring(0, mainKey);
        // ... code to encrypt input ...
    }

    public String decrypt(String input){
        String shiftedAlphabet = alphabet.substring(26 - mainKey) 
            + alphabet.substring(0, 26 - mainKey);
        // ... code to decrypt input
    }