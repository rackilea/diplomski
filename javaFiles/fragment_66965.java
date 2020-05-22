public <T> int someFunction1(T someParam) {
    if (someParam instanceof Integer)
        return someFunction2((Integer) someParam);
    else if (someParam instanceof String)
        return someFunction2((String) someParam);
    else throw new IllegalArgumentException("Expected String or Integer")
}