private String name;
private Float value;

public MySampleClass(String theName, Float theValue) {
    this.name = theName;
    setValueImpl(theValue);
}

public void setName(String n) {
    this.name = n;
}

public void setValue(Float v) {
    setValueImpl(v);
}

private void setValueImpl(Float v) {
    if (v < 0.0f) {
        this.value = 0.0f;
    } else if (v > 1.0f) {
        this.value = 1.0f;
    }
}