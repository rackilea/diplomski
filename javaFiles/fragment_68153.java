class Episode {
    int id;
    String title;

    public Episode(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public static List<Episode> createEpisodeList(int id, List<String> titles) {
        List<Episode> episodes = new ArrayList(titles.size());
        for (String title : titles) {
            episodes.add(new Episode(id, title));
        }
        return episodes;
    }
}