if(current.isNull(key)){
    if (i == keys.length - 1) {
        current.put(key, e.getValue());
    } else {
        JSONObject tmp = new JSONObject();
        current.put(key, tmp);
        current = tmp;
    }
} else {
    current = current.getJSONObject(key);
}