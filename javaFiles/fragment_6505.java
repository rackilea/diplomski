String replaceMultiple (String baseString, String ... replaceParts) {
    for (String s : replaceParts) {
        baseString = baseString.replaceAll(s, "");
    }
    return baseString;
}