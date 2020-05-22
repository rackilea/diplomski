private Enum PreferenceType {
    FIRST("key1"),SECOND("key2"),THIRD("key3");

    static Map<String, PreferenceType> prefMap = new HashMap<String, PreferenceType>();

    private String prefKey;

    PreferenceType(String prefKey) {
        this.prefKey = prefKey;
        prefMap.put(prefKey, this);
    }

    @Override
    public String toString() {
        return prefKey;
    }

    public static PreferenceType getPreferenceTypeFor(final String key) {
        return prefMap.get(key);
    } 
}