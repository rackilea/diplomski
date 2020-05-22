List<String> ArticleIDs = new ArrayList<String>();

for (Element Article : articleID) {
    String value= Article.attr("value");
    System.out.println(value);
}