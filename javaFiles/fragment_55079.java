try {
    Document doc = Jsoup.parse(new URL("http://www.gyte.edu.tr/kategori/120/0/duyurular.aspx"), 1000000);
    Elements elements = doc.getElementsByAttributeValue("class", "news-list");
    System.out.println(elements.size());

    for (Element e : elements) {
        System.out.println(e.toString());
    }
} catch (Exception e) {
    e.printStackTrace();
}