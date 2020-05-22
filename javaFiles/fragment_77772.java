private String encoding = "UTF8";

@Override
public void configure(Map<String, ?> configs, boolean isKey) {
    String propertyName = isKey ? "key.serializer.encoding" : "value.serializer.encoding";
    Object encodingValue = configs.get(propertyName);
    if (encodingValue == null)
        encodingValue = configs.get("serializer.encoding");
    if (encodingValue != null && encodingValue instanceof String)
        encoding = (String) encodingValue;
}