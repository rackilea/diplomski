@Override
List parse(String path, Class clazz) {
    List result = []
    JsonArray jsonArray = new JsonParser()
            .parse(new File(path).getText(CHARSET))
            .getAsJsonArray()

    Gson gson = new Gson()
    jsonArray.each {
        result.add(gson.fromJson(it, clazz))
    }
    return result
}