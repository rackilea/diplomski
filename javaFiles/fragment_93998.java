public class Deneme {

        private List<JsonObject> games;

        public List<JsonObject> getMatches() {
            return games;
        }

        public void setMatches(List<JsonObject> games) {
            this.games = games;
        }
    }

    public static void main(String[] args) {

        Deneme deneme = new Gson().fromJson(json, Deneme.class);

        deneme.getMatches().forEach(System.out::println);
    }