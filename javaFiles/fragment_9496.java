public String getValue(String service, String parameter) {
    String inputKey = service + ":" + parameter;
    String value = name2value.get(inputKey);
    if (value == null) {
        return "";
    } else {
        return value;
    }
}