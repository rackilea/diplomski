class Main {
    public static void main(String[] args) {
        final String json = "{ \"name\": \"William Shakespeare\", \"affiliations\": [ { \"name\": \"Globe Theatre\" }, [] ] }";
        final Gson gson = new GsonBuilder()
                .registerTypeAdapter(Affiliation.class, new AffiliationDeserializer())
                .create();
        final Laureate laureate = gson.fromJson(json, Laureate.class);
        System.out.println(laureate);

    }

    private static class Laureate {
        String name;
        List<Affiliation> affiliations;

        public Laureate(final String name) {
            this.name = name;
        }

        public String toString() {
            return "Laureate[name=" + name + ", affiliations=" + affiliations + "]";
        }
    }

    private static class Affiliation {
        String name;

        public String toString() {
            return "Affiliation[name=" + name +"]";
        }
    }

    private static class AffiliationDeserializer implements JsonDeserializer<Affiliation> {
        // this innerGson doesn't have AffiliationDeserializer registered, 
        // so it won't get stuck in an infinite loop
        private static final Gson innerGson = new Gson();

        @Override
        public Affiliation deserialize(final JsonElement json, final Type typeOfT,
                                       final JsonDeserializationContext context)
        throws JsonParseException {
            if (json.isJsonObject()) {
                return innerGson.fromJson(json, Affiliation.class);
            } else {
                return null;
            }
        }
    }
}