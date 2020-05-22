import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.ObjectMapper;

StatusResponses loginValidator = null;

ObjectMapper objectMapper = new ObjectMapper();
objectMapper.configure(Feature.AUTO_CLOSE_SOURCE, true);

try {
    String res = result.getResponseAsString();//{"status":"true","msg":"success"}
    loginValidator = objectMapper.readValue(res, StatusResponses.class);//replaced result.getResponseAsString() with res
} catch (Exception e) {
    e.printStackTrace();
}