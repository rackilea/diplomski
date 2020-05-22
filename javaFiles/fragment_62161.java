private static JsonObject merge(JsonObject json1Obj, JsonObject json2Obj) {

        Set<Entry<String, JsonElement>> entrySet1 = json1Obj.entrySet();
        for (Entry<String, JsonElement> entry : entrySet1) {
            String key1 = entry.getKey();
            if (json2Obj.get(key1) != null) {
                JsonElement tempEle2 = json2Obj.get(key1);
                JsonElement tempEle1 = entry.getValue();
                if (tempEle2.isJsonObject() && tempEle1.isJsonObject()) {
                    JsonObject mergedObj = merge(tempEle1.getAsJsonObject(),
                            tempEle2.getAsJsonObject());
                    entry.setValue(mergedObj);
                }
            }
        }

        Set<Entry<String, JsonElement>> entrySet2 = json2Obj.entrySet();
        for (Entry<String, JsonElement> entry : entrySet2) {
            String key2 = entry.getKey();
            if (json1Obj.get(key2) == null) {
                json1Obj.add(key2, entry.getValue());
            }
        }
        return json1Obj;
    }