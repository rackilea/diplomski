private static JsonElement getAtPath(JsonElement e, String path) {
        JsonElement current = e;
        String ss[] = path.split("/");
        for (int i = 0; i < ss.length; i++) {
            if(current instanceof JsonObject){
                current = current.getAsJsonObject().get(ss[i]);
            } else if(current instanceof JsonArray){
                JsonElement jsonElement = current.getAsJsonArray().get(0);
                current = jsonElement.getAsJsonObject().get(ss[i]);
            }
        }
        return current;
    }