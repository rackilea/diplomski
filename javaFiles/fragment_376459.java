FileReader reader = new FileReader("file.json");
    JsonParser parser = new JsonParser() ;
    JsonObject jsonObj = (JsonObject) parser.parse(reader);
    JsonArray deviceListFromJSON = (JsonArray) jsonObj.get("Devices");
    reader.close();
    for (int i = 0; i < deviceListFromJSON.size(); i++) {
        JsonObject devices = (JsonObject) deviceListFromJSON.get(i);
        devices.addProperty("deviceNumber", "1234f");
        devices.addProperty("Status", "active");
    }   
    BufferedWriter writer = new BufferedWriter(new FileWriter("file.json"));
    writer.write(jsonObj.toString());
    writer.close();