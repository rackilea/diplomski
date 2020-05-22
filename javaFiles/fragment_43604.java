public static JSONArray removeJsonObjectAtJsonArrayIndex(JSONArray source, int index) throws JSONException {
    if (index < 0 || index > source.length() - 1) {
        throw new IndexOutOfBoundsException();
    }

    final JSONArray copy = new JSONArray();
    for (int i = 0, count = source.length(); i < count; i++) {
        if (i != index) copy.put(source.get(i));
    }
    return copy;
}