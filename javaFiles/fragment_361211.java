Map<Object> jsonIn = JsonParser.parseJsonToMap(theJson);
Map<Object> jsonOut = new HashMap<Object>();
String[] keys = jsonIn.getKeys();
for (String key in keys) {
    Object value = jsonIn.get(key);
    if (value instanceof Map) {
        Map mapValue = (Map) value;
        Object[] valueValues = mapValue.getValues();
        assert valueValues.length == 1;
        jsonOut.add(key, valueValues[0]);
    }
    else {
        jsonOut.add(key, value);
    }
}