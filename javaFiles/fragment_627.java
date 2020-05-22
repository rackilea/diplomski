public class SportDeserializer implements JsonDeserializer<Sport> {
    @Override
    public Sport deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = (JsonObject) json;

        String game = jsonObject.get("game").getAsString();
        JsonElement nullablePeople = jsonObject.get("people");
        String people = nullablePeople == null ? null : nullablePeople.getAsString();

        if (people == null || people.isEmpty()) {
            if (game.equals("football")) {
                people = "elevent";
            }
            else if (game.equals("badminton")) {
                people = "two";
            }
        }

        Sport sport = new Sport();
        sport.game = game;
        sport.people = people;

        return sport;
    }
}