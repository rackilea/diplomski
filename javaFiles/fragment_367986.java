public class JsonUtils {
    public static String javaToJson(Object o) {
            String jsonString = null;
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.UNWRAP_ROOT_VALUE,true);  
                jsonString = objectMapper.writeValueAsString(o);

            } catch (JsonGenerationException e) {
                logger.error(e);
            } catch (JsonMappingException e) {
                logger.error(e);
            } catch (IOException e) {
                logger.error(e);
            }
            return jsonString;
        }

}