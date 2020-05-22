// Create the original ObjectMapper
ObjectMapper objectMapper = new ObjectMapper();
objectMapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);

// Create a clone of the original ObjectMapper
ObjectMapper objectMapper2 = new ObjectMapper();
objectMapper2.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
objectMapper2.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
objectMapper2.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);

// Create a module that references the Contextual Serializer
SimpleModule module = new SimpleModule("JsonId", new Version(1, 0, 0, null));
// All references to SubResource should be run through this serializer
module.addSerializer(SubResource.class, new ContextualJsonIdSerializer(objectMapper2));
objectMapper.registerModule(module);

// Now just use the original objectMapper to serialize