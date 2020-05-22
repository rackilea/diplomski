public class DateDeserializer implements JsonDeserializer<Date> {

  @Override
  public Date deserialize(JsonElement element, Type arg1, JsonDeserializationContext arg2) throws JsonParseException {
      String date = element.getAsString();

      SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
      format.setTimeZone(TimeZone.getTimeZone("GMT"));

      try {
          return format.parse(date);
      } catch (ParseException exp) {
          System.err.println(exp.getMessage());
          return null;
      }
   }
}