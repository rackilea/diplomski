private FormEncodingBuilder makeBuilderFromMap(final Map<String, String> map) {
    FormEncodingBuilder formBody = new FormEncodingBuilder();
    for (final Map.Entry<String, String> entrySet : map.entrySet()) {
        formBody.add(entrySet.getKey(), entrySet.getValue());
    }
    return formBody;
}