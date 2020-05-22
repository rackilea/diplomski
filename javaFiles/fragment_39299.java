package com.company.rest.jersey;
@Provider
@Component
@Produces({MediaType.APPLICATION_JSON})
public class JacksonMapperProvider implements ContextResolver<ObjectMapper> {
   ObjectMapper mapper;

   public JacksonMapperProvider(){
       mapper = new ObjectMapper();
       mapper.configure(Feature.INDENT_OUTPUT, true);

       // Serialize dates using ISO8601 format
       // Jackson uses timestamps by default, so use StdDateFormat to get ISO8601
       mapper.getSerializationConfig().setDateFormat(new StdDateFormat());

       // Deserialize dates using ISO8601 format
       // MilliDateFormat simply adds milliseconds to string if missing so it will parse
       mapper.getDeserializationConfig().setDateFormat(new MilliDateFormat());

       // Prevent exceptions from being thrown for unknown properties
       mapper.configure(
              DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES,false);
   }

   @Override
   public ObjectMapper getContext(Class<?> aClass) {
       return mapper;
   }
}