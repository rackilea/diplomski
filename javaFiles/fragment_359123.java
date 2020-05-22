public JSONObject createJSONObject() {
    JSONObject result = new JSONObject();
    for (int fooIndex = 0; fooIndex < foo.length; fooIndex++) {
        result.put(foo[fooIndex], createBarJsonObject(fooIndex));
    }

    return result;
}

private JSONObject createBarJsonObject(int index) {
    JSONObject result = new JSONObject();
    String[] keys = bar[index];
    for (int barIndex = 0; barIndex < keys.length; barIndex++) {
        result.put(keys[barIndex], createBlarghJsonObject(fooIndex));
    }

    return result;
}

private JSONObject createBlarghJsonObject(int index) {
    JSONObject result = new JSONObject();
    String[] keyValue = blargh[index];
    result.put(keyValue[0], keyValue[1]);

    return result;
}