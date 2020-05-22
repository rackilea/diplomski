public enum FestivalType {

    BIG_MUSIC,
    SMALL_MUSIC,
    FILM,
    FOOD_AND_DRINK;

    private static class SetHolder {
        static Set<String> allSearchTokens = new HashSet<String>();
    }

    final String searchToken;

    FestivalType() {
        String searchToken = name().split("_")[0].toLowerCase();

        if (SetHolder.allSearchTokens.contains(searchToken))
            throw new RuntimeException("Duplicate search token");

        this.searchToken = searchToken;
        SetHolder.allSearchTokens.add(searchToken);
    }
}