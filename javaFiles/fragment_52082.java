public enum UsageCode {
    ANTIQUE ('A'),
    FLOOD_DAMAGED ('F'),
    NEW ('N');
    UNKNOWN ('0')

    private static final Map<Character, UsageCode> charToEnum
            = new HashMap<Character, UsageCode>();

    static { // Initialize map from legacy code to enum constant
        for (UsageCode code : values())
        charToEnum.put(code.getCode(), code);
    }

    // Returns UsageCode for legacy character code, or null if code is invalid
    public static UsageCode fromLegacyCode(char code) {
        return charToEnum.get(code);
    }

    private final char code;

    UsageCode(char code) {
        this.code = code;
    }

    public char getCode() {
        return code;
    }
}