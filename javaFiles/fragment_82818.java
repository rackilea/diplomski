public final class AndAppender implements ConditionAppender {
    private static final AndAppender instance;
    public static AndAppender getInstance() {
        if (instance == null)
            instance = new AndAppender();
        return instance;
    }

    private AndAppender() { }

    @Override
    public String append() {
        return " AND ";
    }
}