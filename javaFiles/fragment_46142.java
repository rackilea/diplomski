public class CCipher {

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private final String shiftedAlphabet;
    private final int mainKey;

    public CCipher(int key) {
        mainKey = key;
        shiftedAlphabet = ALPHABET.substring(mainKey) 
                        + ALPHABET.substring(0, mainKey);
    }