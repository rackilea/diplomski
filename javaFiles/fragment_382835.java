public enum CC {
    MC("MasterCard"),
    V("VISA");

    private CC(String fullString) {
        this.fullString = fullString;
    }

    private String fullString;

    public String getFullString() {
        return this.fullString;
    }

    public static CC of(String fullString) {

        for (CC cc: CC.values()) {
            if (cc.getFullString().equals(fullString) {
                return cc;             
            }
        }
        return null;

    }
}