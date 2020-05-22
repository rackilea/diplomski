public class JsonPlayerSerializer extends JsonSerializer<Player> {

    @Override
    public void serialize(Player player, JsonGenerator gen,    
         SerializerProvider provider) throws IOException, JsonProcessingException {


          super.serialize(player,gen,provider);   
          gen.writeObjectField("history_moves", new JsonObject().put("$binary", myMoves));
    }
}