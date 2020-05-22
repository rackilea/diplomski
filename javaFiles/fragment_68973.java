public class CustomHourDeserializer implements JsonDeserializer<CustomHour> {

    public CustomHour deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {

        String[] data = json.getAsJsonPrimitive().getAsString().split(":");
        int maj = Integer.parseInt(data[0]);
        int min = Integer.parseInt(data[1]);
        return new CustomHour(maj, min);
    }
}