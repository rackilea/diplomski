final String json = "{\"date\" : \"2013-05-11\",\"value\" : 123}";

final ObjectMapper mapper = new ObjectMapper()
        .enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
final List<Point> points = mapper.readValue(json,
        new TypeReference<List<Point>>() {});