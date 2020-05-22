static class AHolder {
    private static AHolder instance;

    static AHolder getInstance() {
        if( instance == null ) {
            instance = new AHolder();
        }
        return instance;
    }

    private AHolder() {}

    private HashMap<String,A> myCollection = new HashMap<>();

    void addA(String key, A val) {
        myCollection.put(key,val);
    }

    boolean hasA(String key) {
        return myCollection.containsKey(key);
    }

    A getA(String key) {
        return myCollection.get(key);
    }
}