void postJson(Map<String, String> map, String url) {
    XMLHttpRequest request = new XMLHttpRequest();

    // Post asynchronously
    request.open("POST", url, true);
    request.setRequestHeader("Content-Type", "application/json;charset=UTF-8");

    // Encode the data as JSON before sending
    String mapAsJson = JSON.stringify(toJsObject(map));
    request.send(mapAsJson);
}

jsweet.lang.Object toJsObject(Map<String, String> map) {
    jsweet.lang.Object jsObject = new jsweet.lang.Object();

    // Put the keys and values from the map into the object
    for (Entry<String, String> keyVal : map.entrySet()) {
        jsObject.$set(keyVal.getKey(), keyVal.getValue());
    }
    return jsObject;
}