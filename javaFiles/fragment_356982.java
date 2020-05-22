JsonParser jp = mapper.getFactory().createParser(jsonSource);
try {
    Value v = mapper.readValue(jp, Value.class);
    if (jp.nextToken() != null) {
        //throw some exception: trailing garbage detected
    }
    return v;
} finally {
    jp.close();
}