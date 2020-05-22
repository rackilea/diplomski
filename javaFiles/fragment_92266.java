public static Document connect(String url) {
    Document doc = null;
    try {
        doc = Jsoup.connect(url).timeout(0).get();
    } catch (IOException ex) {
        ex.printStackTrace();
    }
    return doc;
}