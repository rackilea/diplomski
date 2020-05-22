private static final Function extractValue(Object source) {
    if (source instanceof Attribute) {
        return ((Attribute)source).getValue();
    }
    if (source instanceof Content) {
        return ((Content)source).getValue();
    }
    return String.valueOf(source);
}