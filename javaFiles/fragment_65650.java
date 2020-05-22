JsonObject result = null;
String uri = dbClient.getDBUri() + "_design/myDesignDoc";

 try {
            result = dbClient.findAny(JsonObject.class, uri);
        } catch (Exception e) {
            throw new CustomException("Design document could not be found");
        } finally {
            if (result == null) {
                file = new ClassPathResource("json/designDocData.json").getFile();
                reader = new JsonReader(new FileReader(file));
                data = gson.fromJson(reader, JsonObject.class);

                dbClient.save(data);
            }