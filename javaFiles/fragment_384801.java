public enum PR304MainDb_Possibility1 {
    MODE("@MODE"),
    USERID("@USERID"),
    ROLES("@ROLES"),
    MAX_DOC_COUNT("@MAX_DOC_COUNT");

    private PR304MainDb_Possibility1(String text) {
        this.text = text;
    }

    public final String text;
}

public enum PR304MainDb_Possibility2 {
    MODE,
    USERID,
    ROLES,
    MAX_DOC_COUNT;

    public String getText() {return "@" + name();}
}