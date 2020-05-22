public class XMLGregorianCalendarDeserializer
        implements JsonDeserializer<XMLGregorianCalendar> {
    @Override
    public XMLGregorianCalendar deserialize(JsonElement json, Type typeOfT,
            JsonDeserializationContext context) throws JsonParseException {
        // Easily parse the adapter class first
        XMLGregoriancalendarAdapterClass ac = 
                new Gson().fromJson(json, 
                        XMLGregoriancalendarAdapterClass.class);
        try {
            // Then return a new newXMLGregorianCalendar
            // using values in adapter class
            return DatatypeFactory.newInstance()
                    .newXMLGregorianCalendar(ac.getYear(), ac.getMonth(), 
                            ac.getDay(), ac.getHour(),        
                            ac.getMinute(), ac.getSecond(),
                            ac.getFractionalSecond(), ac.getTimezone());
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        return null;
    }
}