public intarface ValueHolder<T> {
     void putInEditor(String key, Editor editor);
     T getValue();
}

public class StringValueHolder extends ValueHolder<String> {
    private String value;
    // constructor here to initialize the value
    public putInEditor(String key, Editor editor) {
        editor.putString(key, value);
    }

    public String getValue() {
         return value;
    }
}

public class BooleanValueHolder extends ValueHolder<Boolean> {
    private Boolean value;
    // constructor here to initialize the value
    public putInEditor(String key, Editor editor) {
        editor.putBoolean(key, value);
    }

    public Boolean getValue() {
         return value;
    }
}