try{
    JsonReader runThrough = getJsonReader(fileName);
    System.out.println("File found");
    Gson myGson = new Gson();
    JsonParser jsonParser = new JsonParser();
    JsonObject jsonObj =  jsonParser.parse(runThrough).getAsJsonObject();
    JsonArray infoArray = jsonObj.getAsJsonArray("loans");
    System.out.println("Finished Parsing");
    for (JsonElement piece : infoArray){

    }
} catch (Exception e){
    System.out.println(e);
}