static class NewsFeed {
    String news;
    Date date;

    private NewsFeed(String news, Date date) {
        this.news = news;
        this.date = date;
    }

    public String getNews() {
        return news;
    }

    public Date getDate() {
        return date;
    }
}

public static void main(String[] args) throws Exception {
    List<NewsFeed> list = new ArrayList<NewsFeed>();

    list.add(new NewsFeed("A", new Date(System.currentTimeMillis() - 1000)));
    list.add(new NewsFeed("B", new Date())); // This one is the "latest"
    list.add(new NewsFeed("C", new Date(System.currentTimeMillis() - 2000)));

    Collections.sort(list, new Comparator<NewsFeed>() {
        public int compare(NewsFeed arg0, NewsFeed arg1) {
            // Compare in reverse order ie biggest first
            return arg1.getDate().compareTo(arg0.getDate()); 
        }
    });
    NewsFeed latestNewsFeed = list.get(0);
    System.out.println(latestNewsFeed.getNews()); // Prints "B", as expected
}