Document doc;
Map<String,String> hrefMap = new HashMap<String,String>();
try {

    // need http protocol
    doc = Jsoup.connect("http://google.com").get();

// get all links
    Elements links = doc.select("a[href]");
    for (Element link : links) {

             //put elements in the map
            hrefMap.put(link.attr("href"),link.text() );

    }

} catch (IOException e) {
    e.printStackTrace();
}