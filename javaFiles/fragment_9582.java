@SuppressWarnings("unchecked")
public <T> T fromJson(String json, Type typeOfT) throws JsonParseException {
    StringReader reader = new StringReader(json);
    T target = (T) fromJson(reader, typeOfT);
    return target;
}