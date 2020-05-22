public String alertSystemMessage() throws IOException {
    String url = "http://example.com/alertpage";
    Document document = Jsoup.connect(url).get();
    String alertText = document.select("p").first().text();        
    return alertText;
}