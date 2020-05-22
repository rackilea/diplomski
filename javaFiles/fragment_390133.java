private Collection<String> value;

public Collection<String> getValue() {
    return value;
}

public void setValue(Object value) {
    if (value instanceof Collection) {
        this.value = (Collection<String>) value;
    } else {
        this.value = Arrays.asList((String) value);
    }
}