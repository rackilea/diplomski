static String getValueFromKey(String s, String key) {
    Matcher m = Pattern.compile(
            "(?<=^|\\|)\\s*" + Pattern.quote(key) + "\\b\\s*=\\s*(?<value>[^|]*)")
            .matcher(s);
    if (m.find())
        return m.group("value");
    else
        return null;// or maybe return empty String "" but that may be misleading 
                    // for values which are really empty Strings
}