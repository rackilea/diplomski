public class JsonResponse {
    public static class Item {
        String name;
    }

    public static class Tracks extends Item {
        List<Track> tracks;
    }

    public static class Albums extends Item {
        List<Album> albums;
    }

    public static class Playlists extends Item {
        List<Playlist> playlists;
    }

    public static class JsonResponseDeserialize implements JsonDeserializer<List<? extends Item>> {
        Gson gson = new Gson();
        @Override
        public List<? extends Item> deserialize(JsonElement el, Type type, JsonDeserializationContext context) throws JsonParseException {
            List<Item> ls = new ArrayList<Item>();
            JsonArray jarr = el.getAsJsonArray();
            for (JsonElement e : jarr) {
                Item i;
                if (e.getAsJsonObject().get("tracks") != null){
                    i = gson.lsomJson(e, Tracks.class);
                    if (i != null) {
                        ls.add(i);
                        continue;
                    }
                }
                if (e.getAsJsonObject().get("albums") != null){
                    i = gson.lsomJson(e, Albums.class);
                    if (i != null) {
                        ls.add(i);
                        continue;
                    }
                }
                if (e.getAsJsonObject().get("playlists") != null){
                    i = gson.lsomJson(e, Playlists.class);
                    if (i != null) {
                        ls.add(i);
                        continue;
                    }
                }
            }
            return ls;
        }
    }

    private Tracks _tracks;
    private Albums _albums;
    private Playlists _playlists;
}