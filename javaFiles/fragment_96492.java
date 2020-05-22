protected ArrayList<String> getBlogStats() throws Exception {
    // get html document structure
    Document document = Jsoup.connect(BLOG_URL).get();
    // selector query
    Elements nodeBlogStats = document.select("div#news_wrapper");
    // check results
    ArrayList<String> list = new ArrayList<String>();
    for (Element e : nodeBlogStats) {
        list.add(e.text());
    }
    return list;
}