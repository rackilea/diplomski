public class DataMapperJsonDeserializer extends JsonDeserializer<DataMapper> {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    static {
        SimpleModule module = new SimpleModule();
        module.addDeserializer(BigInteger.class, new CustomBigIntegerJsonDeserializer());
        module.addDeserializer(BigDecimal.class, new CustomBigDecimalJsonDeserializer());
        module.addDeserializer(Boolean.class, new CustomBooleanJsonDeserializer());
        module.addDeserializer(String.class, new CustomStringJsonDeserializer());
        objectMapper.registerModule(module);
        objectMapper.addMixIn(DataMapper.class, DefaultJsonDeserializer.class);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.setDateFormat(simpleDateFormat);
    }

    @Override
    public DataMapper deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return objectMapper.readValue(jsonParser, DataMapper.class);
    }

    @JsonDeserialize
    private interface DefaultJsonDeserializer {
        // Reset default json deserializer
    }

}