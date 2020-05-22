public enum SingletonEnum {

    INSTANCE;
    private final Object obj = new Object();

    public Object getObject() {
        return obj;
    }
}