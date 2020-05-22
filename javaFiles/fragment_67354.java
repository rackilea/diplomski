class SortedSetDeserializer implements JsonDeserializer<SortedPersonSet> {

    @Override
    public SortedPersonSet deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        SortedPersonSet people = new SortedPersonSet(Comparator.comparingLong(Person::getAge));
        if (json.isJsonArray()) {
            JsonArray array = json.getAsJsonArray();
            array.forEach(e -> {
                people.add(context.deserialize(e, Person.class));
            });
        }
        return people;
    }
}