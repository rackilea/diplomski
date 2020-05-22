public class SoJsonAnswer {

        private static final Type type = 
                new TypeToken<List<InfoItem>>(){}.getType();

        public static void main(String[] args) {
            String json = "{paste it here}";
            JsonElement data = new JsonParser().parse(json);

            JsonArray info = data
                    .getAsJsonObject() // treat parsed data as map
                    .getAsJsonObject("mobiledata") // get map
                    .getAsJsonArray("info"); // get list

            // map parsed jsonObjects into POJOs
            List<InfoItem> items = new Gson().fromJson(info, type);

            System.out.println(items);
        }

    }

    class InfoItem {
        String title;
        String uri;

        @Override
        public String toString() {
            return "title=" + title + ", uri=" + uri;
        }
    }