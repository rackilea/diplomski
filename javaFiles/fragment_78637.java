public static Result add() throws Exception {
    Myapps user = new Myapps();
    try {
        JsonNode requestBody = request().body().asJson();
         ObjectMapper mapper = new ObjectMapper();

                     ObjectReader reader = mapper.readerForUpdating(user);

                     user = reader.readValue(requestBody);
        user.save();

    } catch (Exception e) {
        e.printStackTrace();
    }

    return ok(Json.toJson("inserted value is" + user));
}