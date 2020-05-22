private static Document connect() {
    String url = "http://www.transfermarkt.co.uk/real-madrid/startseite/verein/418";
    Document doc = null;
    try {
        doc = Jsoup.connect(url)
               .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
               .referrer("http://www.google.com")              
               .get();
    } catch (NullPointerException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (HttpStatusException e) {
        e.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    return doc;
}