@Test
  public void configureObjectMapperTest() throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModule(new JodaModule());
//    objectMapper.configure(SerializationFeature.WRITE_DURATIONS_AS_TIMESTAMPS, false);
    objectMapper.setSerializationInclusion(Include.NON_EMPTY);
    Thing thing = new Thing();
    LocalTime localTime = new LocalTime(12389340L);
    thing.setLocalTime(localTime);
    System.out.println("Never manages to print this out: " + objectMapper.writeValueAsString(thing));
  }