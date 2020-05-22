@Stateless
    @Path("v1/cardapio")
    public class CardapioResource {
            @GET
            @Produces("application/json")
            @Path("/") // can be removed actually
            public String getCardapio(@QueryParam("id") int id) {

                JsonArray array = (JsonArray) gson.toJsonTree(ejb.findById(id));
                JsonObject obj = new JsonObject();
                obj.add("dados", array);
                return obj.toString();
            }
    }