import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;

...

if (Response.Status.OK.getStatusCode() == response.getStatus()) {
  ObjectMapper mapper = new ObjectMapper();
  // Validate object status status_code or message.header.status_code
  String jsonString = IOUtils.toString(inputStream, StandardCharsets.UTF_8.name());

  JsonNode jsonObject = mapper.readTree(jsonString);
  String statusCode =
          jsonObject.get("message")
                  .get("header")
                  .get("status_code")
                  .toString();

  if(statusCode.equalsIgnoreCase("200")) {
    MappingJsonFactory factory = new MappingJsonFactory();
    JsonParser parser = factory.createJsonParser((InputStream) response.getEntity());
    MMResponse resp = parser.readValueAs(MMResponse.class);
    System.out.println(resp.getMessage().getBody().getLyrics().getLyrics_body());  
  }
}