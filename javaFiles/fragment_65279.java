public enum KeyWord {
    SELF("self"),
    RESULT("callResult")
    ;

    public String getKeyword() {
        return keyword;
    }

    private KeyWord(String keyword) {
        this.keyword = keyword;
    }

    private final String keyword;
}