public static void main(String[] args) throws IOException {
    Document doc = Jsoup.connect("http://www.housetime.fm/tracklist/").get();
    Elements links = doc.getElementsByClass("rc_release_list_item_picture");//Get all the divs
    Elements imgs = links.select("img[alt]");//get all images with alt attribute
    Iterator<Element> iterator = imgs.iterator();
    while (iterator.hasNext()) {
        Element element = (Element) iterator.next();
        String altString = element.attr("alt");//get the value of the alt attribute
        System.out.println(altString);
    }
}