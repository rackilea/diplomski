Collections.sort(news, new Comparator<NewsItem>() {
    @Override
    public int compare(NewsItem newsItem1, NewsItem newsItem2) {
        return Long.valueOf(newsItem2.getUpdateTime()).compareTo(
               Long.valueOf(newsItem1.getUpdateTime()));
    }
});