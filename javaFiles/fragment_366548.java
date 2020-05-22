JSONValue jsonValue;
JSONArray jsonArray;
JSONObject jsonObject;
JSONString jsonString;
jsonValue = JSONParser.parseStrict(incomingJsonRespone);
// parseStrict is available in GWT >=2.1
// But without it, GWT is just internally calling eval()
// which is strongly discouraged for untrusted sources

if ((jsonObject = jsonValue.isObject()) == null) {
    Window.alert("Error parsing the JSON");
    // Possibilites: error during download,
    // someone trying to break the application, etc.
}

jsonValue = jsonObject.get("d"); // Actually, this needs
                                 // a null check too
if ((jsonArray = jsonValue.isArray()) == null) {
    Window.alert("Error parsing the JSON");
}

jsonValue = jsonArray.get(0);
if ((jsonObject = jsonValue.isObject()) == null) {
    Window.alert("Error parsing the JSON");
}

jsonValue = jsonObject.get("Desc");
if ((jsonString = jsonValue.isString()) == null) {
    Window.alert("Error parsing the JSON");
}

Window.alert(jsonString.stringValue()); // Finally!