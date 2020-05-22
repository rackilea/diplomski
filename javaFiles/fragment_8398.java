import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;  

JsonNode root = null;
String json = JsonRenderer.renderDataTable(generateDataTable(), true, false).toString();

        try{
            JsonParser parser = new JsonFactory().createJsonParser(json)
                .enable(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES)
                .enable(JsonParser.Feature.ALLOW_SINGLE_QUOTES);
                 root = new ObjectMapper().readTree(parser);
            }catch(Exception e){
                logger.error(e.getMessage());
            }

        response.getWriter().println(root.toString());