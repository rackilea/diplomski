public class CustomDeserializer implements JsonDeserializer<CRMActivity> {

    public CRMActivity deserialize(JsonElement json, Type typeOfT,
            JsonDeserializationContext context) throws JsonParseException {

        if (json == null)
            return null;

        JsonObject jo = json.getAsJsonObject();

        String type = jo.get("Type").getAsString();
        String subject = jo.get("Subject").getAsString();
        String endTimeAsString = jo.get("EndTime").getAsString();
        String startTimeAsString = jo.get("StartTime").getAsString();

        startTimeAsString = startTimeAsString.replace("/Date(", "").replace(")/", "");
        endTimeAsString = endTimeAsString.replace("/Date(", "").replace(")/", "");

        return new CRMActivity(type, new Date(Long.valueOf(startTimeAsString)),
                new Date(Long.valueOf(endTimeAsString)), subject);

    }