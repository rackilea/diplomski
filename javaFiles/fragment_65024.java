public class JsonDateDeserializer implements com.google.gson.JsonDeserializer<Date>{

public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

    String s = json.getAsJsonPrimitive().getAsString();

    String s1 = s.substring(6, s.length() - 2);

    String[] saa = s1.split("\\+");

    long l = Long.parseLong(saa[0]);
    Date d = new Date(l);
    return d;
}
}