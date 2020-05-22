public JsonArray createJsonArrayFromList(List<Person> list) {
    JsonArray jsonArray = Json.createArrayBuilder();
    for(Person person : list) {
        jsonArray.add(Json.createObjectBuilder()
            .add("firstname", person.getFirstName())
            .add("lastname", person.getLastName()));
    }
    jsonArray.build();
    return jsonArray;
}