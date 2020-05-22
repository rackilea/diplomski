private void fetchNews() {  
    Map<String, String> data = new HashMap<>();
    data.put("category", "Sports");
    data.put("language", String.valueOf(2));

    // simplified call
    newsService.getNews(data);
}