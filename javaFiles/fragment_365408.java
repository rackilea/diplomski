public class JsonDateDeserializer implements JsonDeserializer<Date> {
   public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
      String s = json.getAsJsonPrimitive().getAsString();
      long l = Long.parseLong(s.substring(6, s.length() - 2));
      Date d = new Date(l);
      return d; 
   } 
}