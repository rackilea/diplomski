private IntegerProperty currentKey = new SimpleIntegerProperty(1);

public int getCurrentKey() {
    return currentKey.get();
}

public void setCurrentKey(int val) {
    return currentKey.set(val);
}

public IntegerProperty currentKeyProperty() {
    return currentKey;
}