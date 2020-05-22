try {    
    ObjectMapper mapper = new ObjectMapper();
    ClassPathResource resource = new ClassPathResource("resourceFile");
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    mapper.configure(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
    TypeReference<HashMap<String, Map<String, String>>> typeRef = new TypeReference<HashMap<String, Map<String, String>>>() {};
    cmMappings = mapper.readValue(resource.getInputStream(), typeRef);
} catch (Exception ex) {
   // log error    
}