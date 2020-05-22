protected void doSetValue(final Object value) {
    if (value instanceof String) {
        ((CCombo) getControl()).setText((String) value);
    } else {
        super.doSetValue(value);
    }
}

@Override
protected Object doGetValue() {
    final Object value = super.doGetValue();
    if (value instanceof Integer && (Integer) value == -1) {
        return ((CCombo) getControl()).getText();
    }
    return value;
}