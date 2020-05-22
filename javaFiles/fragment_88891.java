@Override
public Map<String, CalendarMatchDataDto> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
        throws IOException, JsonProcessingException {

    Map<String, CalendarMatchDataDto> mapToReturn = new  HashMap<String, CalendarMatchDataDto>();
    JSONObject flux;
    try {
        flux = new JSONObject(jsonParser.getValueAsString());
        ObjectMapper mapper = new ObjectMapper();
         Iterator<String> iter = flux.keys();
            while (iter.hasNext()) {
                String key = iter.next();
                try {
                    Object value = flux.get(key);
                    CalendarMatchDataDto calendarMatchDataDto =  mapper.readValue(value.toString(), CalendarMatchDataDto.class); 
                    if(key!=null && calendarMatchDataDto!=null)
                        mapToReturn.put(key, calendarMatchDataDto);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
    } catch (JSONException e1) {
        e1.printStackTrace();
    }




    return mapToReturn;



}