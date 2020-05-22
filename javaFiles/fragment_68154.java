List<Episode> episodesList = new ArrayList();

void setSeries(List<Series> series) {
    for (Series s : series) {
        episodesList.addAll(Episode.createEpisodeList(s.id, s.getEpisododes()));
    }
    notifyDataSetChanged();
}