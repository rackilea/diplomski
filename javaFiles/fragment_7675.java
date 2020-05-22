public class CustomListingDeserializer extends JsonDeserializer<Map<String, Listing>>{

    public CustomListingDeserializer() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public Map<String, Listing> deserialize(JsonParser arg0, DeserializationContext arg1)
            throws IOException, JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = arg0.readValueAsTree();

        try
        {
            return mapper.readValue(node.toString(), new TypeReference<Map<String,Listing>>(){});

        }
        catch (JsonMappingException e)
        {
            System.out.println("Issue in deserializing : " + e.getMessage() + "for :" + node.toString());
        }
        catch (Exception e)
        {
            throw e;
        }
        // TODO Auto-generated method stub
        return null;
    }

}