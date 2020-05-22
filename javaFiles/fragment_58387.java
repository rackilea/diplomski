public void process() {
    Map<String, Object> target = null;
    Source<Boolean> source = null;
    Boolean value = addIfMatters(target, source, true);  // How can I avoid the cast on this line?
    if (value) {
        // I have some stuff to do here
    }
}

private <T> T addIfMatters(Map<String, Object> target, Source<T> source, T defaultValue) {
    T value = null;
    if (needed(source)) {
        value = source.getValue();
        if (value == null) {
            value = defaultValue;
        }
}
    return value;
}    

public boolean needed(Source source) {
    return true;
}

public class Source<T> {
    public T getValue() {
        return ...;
    }
}