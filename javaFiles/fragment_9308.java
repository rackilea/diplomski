Object key;


public void setValue(Object value) {
    if (key != null) {
        // ignore or throw exception, depending on your business logic
    } else {
        key = value;
    } 
}