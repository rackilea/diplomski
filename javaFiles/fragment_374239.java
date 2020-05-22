public String getFirstValue(String name) {
    return getFirstValue(name, false);
}

public String getFirstValue(String name, boolean ignoreCase) {
    return getFirstValue(name, ignoreCase, null);
}

public String getFirstValue(String name, boolean ignoreCase, String defaultValue) {
    String result = defaultValue;
    NamedValue<String> param = getFirst(name, ignoreCase);

    if ((param != null) && (param.getValue() != null)) {
        result = param.getValue();
    }

    return result;
}