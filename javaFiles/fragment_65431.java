//convert your json string into a json object
JsonElement element = new JsonParser().parse(jsonString);
JsonObject  object = element.getAsJsonObject();

//get the relevant value from your object
String result = object.get("type").toString();

//compare and convert accordingly
if (result.equals("type1")) {
    ObjectOne object = gson.fromJson(element, ObjectOne.class);
} else {
    ObjectTwo object = gson.fromJson(element, ObjectTwo.class);
}