JacksonNonBlockingObjectMapperFactory factory = new JacksonNonBlockingObjectMapperFactory();
factory.setJsonDeserializers(Arrays.asList(new StdDeserializer[]{
    // StdDeserializer, here, comes from Jackson (org.codehaus.jackson.map.deser.StdDeserializer)
    new StdDeserializer.ShortDeserializer(Short.class, null),
    new StdDeserializer.IntegerDeserializer(Integer.class, null),
    new StdDeserializer.CharacterDeserializer(Character.class, null),
    new StdDeserializer.LongDeserializer(Long.class, null),
    new StdDeserializer.FloatDeserializer(Float.class, null),
    new StdDeserializer.DoubleDeserializer(Double.class, null),
    new StdDeserializer.NumberDeserializer(),
    new StdDeserializer.BigDecimalDeserializer(),
    new StdDeserializer.BigIntegerDeserializer(),
    new StdDeserializer.CalendarDeserializer()
}));
ObjectMapper om = factory.createObjectMapper();